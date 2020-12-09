package me.cocode.jike.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.cocode.jike.common.cro.R;
import me.cocode.jike.dao.FollowMapper;
import me.cocode.jike.entity.Follow;
import me.cocode.jike.security.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 2020/12/9 09:33
 * 关注管理
 * @author xiaodingsiren
 */
@RestController
@RequestMapping("/follow")
@Api(tags = "关注管理")
public class FollowController {

    @Autowired
    private FollowMapper followMapper;


    @GetMapping
    @RequiresAuthentication
    @ApiOperation("获取已经关注的用户们")
    public R<List<Integer>> getFollowingUsers(){
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());
        return R.success(followMapper.getFollowingUserIds(userId));
    }

    @PostMapping
    @RequiresAuthentication
    @ApiOperation("关注其他用户")
    public R followingOthers(@RequestParam("followingUserId") Integer followingUserId){
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());
        if (followingUserId.equals(userId)){
            return R.failed("不能关注自己哦");
        }
        Follow follow = new Follow();
        follow.setUserId(userId);
        follow.setFollowingUserId(followingUserId);
        followMapper.insert(follow);
        followMapper.increaseUserFollowing(userId);
        followMapper.increaseUserFollowed(followingUserId);
        return R.success(null);
    }

    @DeleteMapping
    @RequiresAuthentication
    @ApiOperation("取消关注其他用户")
    public R cancelFollowingOthers(@RequestParam("cancelFollowingUserId") Integer cancelFollowingUserId){
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());
        Follow follow = new Follow();
        follow.setUserId(userId);
        follow.setFollowingUserId(cancelFollowingUserId);
        followMapper.delete(follow);
        followMapper.decreaseUserFollowing(userId);
        followMapper.decreaseUserFollowed(cancelFollowingUserId);
        return R.success(null);
    }

}
