package me.cocode.jike.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.cocode.jike.common.cro.R;
import me.cocode.jike.config.RabbitmqConfig;
import me.cocode.jike.dao.LikesMapper;
import me.cocode.jike.dao.TokenMapper;
import me.cocode.jike.entity.Likes;
import me.cocode.jike.entity.Token;
import me.cocode.jike.security.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * 2020/12/3 15:12
 * 点赞管理
 * @author xiaodingsiren
 */
@RestController
@RequestMapping("/like")
@Api(tags = "点赞管理")
@Slf4j
public class LikeController {

    @Autowired
    private LikesMapper likesMapper;



    @GetMapping("/trend")
    @RequiresAuthentication
    @ApiOperation("获取用户点赞过的动态")
    public R<List<Likes>> getLikedTrend() {
        // 获取用户id
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());
        Example example = new Example(Likes.class);
        example.selectProperties("trendId");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId);
        return R.success(likesMapper.selectByExample(example));
    }

    @GetMapping("/comm")
    @RequiresAuthentication
    @ApiOperation("获取用户点赞过的评论")
    public R<List<Likes>> getLikedComm() {
        // 获取用户id
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());

        Example example = new Example(Likes.class);
        example.selectProperties("commentId");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId).andNotEqualTo("commentId",0);
        return R.success(likesMapper.selectByExample(example));
    }

    @PostMapping("/trend")
    @RequiresAuthentication
    @Transactional(rollbackFor=Exception.class)
    @ApiOperation("点赞动态")
    public R likeTrend(@RequestBody Map<String,Object> trendIdJson) {
        Integer trendId = (Integer) trendIdJson.get("trendId");
        // 先查询是否点赞过
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());

        Example example = new Example(Likes.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("trendId", trendId).andEqualTo("userId",userId);
        if (likesMapper.selectCountByExample(example) >0){
            R.failed("已经点赞过咯哦");
        }
        // 新增点赞
        Likes newLikes = new Likes();
        newLikes.setTrendId(trendId);
        newLikes.setUserId(userId);
        newLikes.setCommentId(0);
       likesMapper.insert(newLikes);
        //更新动态中的点赞数
        return R.success( likesMapper.increaseTrendLikesCount(trendId));
    }

    @DeleteMapping("/trend")
    @RequiresAuthentication
    @Transactional(rollbackFor=Exception.class)
    @ApiOperation("取消点赞动态")
    public R cancelLikeTrend(@RequestParam("trendId") Integer trendId) {
        // 先查询是否点赞过
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());

        Example example = new Example(Likes.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("trendId", trendId).andEqualTo("userId",userId);

        // 删除点赞
        likesMapper.deleteByExample(example);
        //更新动态中的点赞数
        return R.success(likesMapper.decreaseTrendLikesCount(trendId));
    }

    @PostMapping("/comm")
    @RequiresAuthentication
    @Transactional(rollbackFor=Exception.class)
    @ApiOperation("点赞评论")
    public R likeComm(@RequestBody Map<String,Object> commIdJson) {
        Integer commId = (Integer) commIdJson.get("commId");
        Integer trendId = (Integer) commIdJson.get("trendId");
        // 先查询是否点赞过
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());

        Example example = new Example(Likes.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("commentId", commId).andEqualTo("userId",userId);
        if (likesMapper.selectCountByExample(example) >0){
            R.failed("已经点赞过咯哦");
        }
        // 新增点赞
        Likes newLikes = new Likes();
        newLikes.setTrendId(trendId);
        newLikes.setUserId(userId);
        newLikes.setCommentId(commId);
        likesMapper.insert(newLikes);
        //更新动态中的点赞数
        return R.success(likesMapper.increaseCommLikesCount(commId));
    }

    @DeleteMapping("/comm")
    @RequiresAuthentication
    @Transactional(rollbackFor=Exception.class)
    @ApiOperation("取消点赞评论")
    public R cancelLikeComm(@RequestParam("commId") Integer commId) {
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());

        Example example = new Example(Likes.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("commentId", commId).andEqualTo("userId",userId);

        // 删除点赞记录
        likesMapper.deleteByExample(example);
        //更新动态中的点赞数
        return R.success(likesMapper.decreaseCommLikesCount(commId));
    }
}
