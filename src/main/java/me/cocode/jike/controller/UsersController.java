package me.cocode.jike.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import me.cocode.jike.common.cro.P;
import me.cocode.jike.common.cro.R;
import me.cocode.jike.common.cro.ResultCode;
import me.cocode.jike.dao.UserInfoMapper;
import me.cocode.jike.dao.UsersMapper;
import me.cocode.jike.dto.UserPersonalDto;
import me.cocode.jike.entity.Users;
import me.cocode.jike.security.JwtUtils;
import me.cocode.jike.service.UserService;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

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
    private UserInfoMapper userInfoMapper;


    @Autowired
    private UsersMapper usersMapper;

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
        newUser.setPassword(new Md5Hash(password, userName, 3).toString());
        userService.insert(newUser);
        return R.success(null);
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
        logger.info("crypto => " + crypto);
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
    public R<List<UserPersonalDto>> getUserCards(){
        return R.success(userInfoMapper.getUserInfoCard());
    }

    @GetMapping("/info")
    @ApiOperation("获取用户基本信息")
    @RequiresAuthentication
    public R<Users> getUserInfo() {
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());
        Example example = new Example(Users.class);
        example.selectProperties("userName", "avatar", "signature", "following", "followed", "cover")
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

}
