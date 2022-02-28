package me.cocode.jike.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.cocode.jike.common.cro.R;
import me.cocode.jike.dao.*;
import me.cocode.jike.dto.Code2SessionDTO;
import me.cocode.jike.dto.MpLoginCallBackDto;
import me.cocode.jike.dto.UserPersonalDto;
import me.cocode.jike.dto.WxUserInfoDto;
import me.cocode.jike.entity.Follow;
import me.cocode.jike.entity.UserInfo;
import me.cocode.jike.entity.Users;
import me.cocode.jike.entity.WxAccount;
import me.cocode.jike.security.JwtUtils;
import me.cocode.jike.service.UserService;
import me.cocode.jike.service.WxAccountService;
import me.cocode.jike.utils.mbg.HttpUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Example;

import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.util.Date;
import java.util.List;

/**
 * 2020/11/25 21:27
 *
 * @author xiaodingsiren
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户管理")
public class UsersController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private TrendMapper trendMapper;

    @Autowired
    private LikesMapper likesMapper;

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private FollowMapper followMapper;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Autowired
    private WxAccountService wxAccountService;

    @PostMapping
    @ApiOperation("用户注册")
    public R saveUser(@RequestParam("userName") String userName,
                      @RequestParam("password") String password) {
        Users byName = userService.selectOneByName(userName);
        if (byName != null) {
            return R.failed("用户名已存在");
        }
        Users newUser = new Users();
        newUser.setUserName(userName);
        String crypto = new Md5Hash(password, userName, 3).toString();
        logger.info("name=> {},password => {},crypto => {}" ,userName, password,crypto);
        newUser.setPassword(crypto);
        userService.insertSelective(newUser);
        userInfoMapper.insert(new UserInfo());
        return R.success(null);
    }

    /**
     * 微信的 code2session 接口 获取微信用户信息
     * 官方说明 : https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html
     */
    private String code2Session(String jsCode) {
        String code2SessionUrl = "https://api.weixin.qq.com/sns/jscode2session";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("appid", "wx2cbe03c448b7c29a");
        params.add("secret", "d2a18754b34d32099d64de829331db63");
        params.add("js_code", jsCode);
        params.add("grant_type", "authorization_code");
        URI code2Session = HttpUtil.getURIwithParams(code2SessionUrl, params);
        return restTemplate.exchange(code2Session, HttpMethod.GET, new HttpEntity<String>(new HttpHeaders()), String.class).getBody();
    }

    @PostMapping("/wxLogin")
    @ApiOperation("微信用户登录")
    public R login(@RequestBody MpLoginCallBackDto mpLoginCallBackDto) {
        // 1. code2session返回JSON数据
        String resultJson = code2Session(mpLoginCallBackDto.getCode());
        WxUserInfoDto userInfoDto = mpLoginCallBackDto.getWxUserInfoDto();
        if (resultJson == null || userInfoDto == null) {
            return R.failed("登录失败");
        }
        //2 . 解析数据
        Code2SessionDTO response = JSON.toJavaObject(JSON.parseObject(resultJson), Code2SessionDTO.class);
        if (!"0".equals(response.getErrcode())) {
            throw new AuthenticationException("code2session失败 : " + response.getErrmsg());
        } else {
            //3 . 先从本地数据库中查找用户是否存在
            Example example = new Example(WxAccount.class);
            example.selectProperties("id", "openId", "sessionKey", "userId", "lastTime")
                    .and()
                    .andEqualTo("openId", response.getOpenid());
            WxAccount wxAccount = wxAccountService.selectOneByExample(example);
            Users user;
            //不存在就新建用户
            if (wxAccount == null) {
                wxAccount = new WxAccount();
                // 整合用户表
                user = new Users();
                user.setPassword(new Md5Hash(response.getOpenid(), userInfoDto.getNickName(), 3).toString());
                user.setUserName(userInfoDto.getNickName());
                user.setAvatar(userInfoDto.getAvatarUrl());
                userService.insertSelective(user);
                userInfoMapper.insert(new UserInfo());
                //获取插入后实体的id
                Integer id = user.getId();
                wxAccount.setOpenId(response.getOpenid());
                wxAccount.setUserId(id);
                wxAccount.setSessionKey(response.getSession_key());
                wxAccount.setLastTime(new Date(System.currentTimeMillis()));
                wxAccountService.insert(wxAccount);
            }
            user = userService.selectByPrimaryKey(wxAccount.getUserId());
            //4 . 更新sessionKey和 登陆时间
            wxAccount.setSessionKey(response.getSession_key());
            wxAccount.setLastTime(new Date(System.currentTimeMillis()));
            wxAccountService.updateByPrimaryKeySelective(wxAccount);
            //5 . JWT 返回自定义登陆态 Token
            String token = JwtUtils.sign(wxAccount.getUserId(), user.getPassword());
            return R.success(token, "登录成功");
        }
    }


    @PostMapping("/login")
    @ApiOperation("用户登录")
    public R login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        Users byName = userService.selectOneByName(userName);
        if (byName == null) {
            return R.failed("账号不存在!");
        }
        logger.info("byName => " + byName.toString());
        String crypto = new Md5Hash(password, userName, 3).toString();
        logger.info("name=> {},password => {},crypto => {}" ,userName, password,crypto);
        if (byName.getPassword().equals(crypto)) {
            String token = JwtUtils.sign(byName.getId(), crypto);
            return R.success(token, "登录成功");
        }
        return R.failed("账号或密码错误");
    }


    @GetMapping("/logout")
    @ApiOperation("用户登出")
    @RequiresAuthentication
    public R logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
            return R.success(null);
        } else {
            return R.failed("登出失败,未认证!");
        }
    }


    @GetMapping("/info/cards")
    @ApiOperation("获取用户卡片")
    public R<List<UserPersonalDto>> getUserCards() {
        return R.success(userInfoMapper.getUserInfoCard());
    }

    @GetMapping("/info")
    @ApiOperation("获取用户基本信息")
    @RequiresAuthentication
    public R<Users> getUserInfo() {
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());
        Example example = new Example(Users.class);
        example.selectProperties("id", "userName", "avatar", "signature", "following", "followed", "cover")
                .and()
                .andEqualTo("id", userId);
        return R.success(userService.selectOneByExample(example));
    }

    @GetMapping("/info/others")
    @ApiOperation("获取其他用户基本信息")
    public R<Users> getUserInfo(@RequestParam("userId") Integer userId) {
        Example example = new Example(Users.class);
        example.selectProperties("userName", "avatar", "signature", "following", "followed", "cover")
                .and()
                .andEqualTo("id", userId);
        return R.success(userService.selectOneByExample(example));
    }

    @GetMapping("/personal")
    @RequiresAuthentication
    @ApiOperation("获取用户自己的档案")
    public R<UserPersonalDto> getUserPersonal() {
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());
        return R.success(userInfoMapper.getUserPersonalInfo(userId));
    }

    @GetMapping("/personal/others")
    @ApiOperation("获取其他用户的档案")
    public R<UserPersonalDto> getUserPersonal(@RequestParam("userId") Integer userId) {
        return R.success(userInfoMapper.getUserPersonalInfo(userId));
    }

    @PostMapping("/personal")
    @RequiresAuthentication
    @ApiOperation("修改个人档案")
    public R updatePersonal(@RequestBody UserPersonalDto userPersonalDto) {
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());
        return R.success(userInfoMapper.updateUserPersonal(userPersonalDto.getUserName(),
                userPersonalDto.getUserAvatar(),
                userPersonalDto.getSignature(),
                userPersonalDto.getCover(),
                userPersonalDto.getBirthday(),
                userPersonalDto.getGender(),
                userPersonalDto.getEmotion(),
                userId));
    }

    @DeleteMapping("/delete")
    @Transactional(rollbackFor=Exception.class)
    @ApiOperation("注销用户账号")
    public R deleteUser() {
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());
        Example followingExample = new Example(Follow.class);
        followingExample.selectProperties("id", "userId", "followingUserId")
                .and()
                .andEqualTo("userId", userId);
        List<Follow> followings = followMapper.selectByExample(followingExample);
        for (Follow following : followings) {
            followMapper.decreaseUserFollowed(following.getFollowingUserId());
        }
        Example followedExample = new Example(Follow.class);
        followedExample.selectProperties("id", "userId", "followingUserId")
                .and()
                .andEqualTo("followingUserId", userId);
        List<Follow> followeds = followMapper.selectByExample(followedExample);
        for (Follow followed : followeds) {
            followMapper.decreaseUserFollowing(followed.getUserId());
        }
        userService.deleteUserById(userId);
        userInfoMapper.deleteUsersInfo(userId);
        trendMapper.deleteUsersTrend(userId);
        likesMapper.deleteUsersLikes(userId);
        commentsMapper.deleteUsersComments(userId);
        followMapper.deleteUsersFollow(userId);
        followMapper.deleteUsersFollowing(userId);
        return R.success(null);
    }

}
