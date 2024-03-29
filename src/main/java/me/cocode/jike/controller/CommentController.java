package me.cocode.jike.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.cocode.jike.common.cro.R;
import me.cocode.jike.dto.CommentDto;
import me.cocode.jike.entity.Comments;
import me.cocode.jike.security.JwtUtils;
import me.cocode.jike.service.CommentService;
import me.cocode.jike.service.TrendService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 2020/11/30 15:18
 * 评论管理
 * @author xiaodingsiren
 */
@RestController
@RequestMapping("/comm")
@Api(tags = "评论管理")
public class CommentController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommentService commentService;


    @Autowired
    private TrendService trendService;

    @GetMapping
    @ApiOperation("获取动态评论")
    public R<List<CommentDto>> getComm(@RequestParam("trendId") Integer trendId){
        return R.success(commentService.getCommByTrendId(trendId));
    }

    @PostMapping
    @RequiresAuthentication
    @Transactional(rollbackFor=Exception.class)
    @ApiOperation("发布评论")
    public R postComment(@RequestBody String postCommJson){
        // 添加新评论
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());
        Comments comments = JSON.parseObject(postCommJson, Comments.class);
        comments.setCreateTime(new Date());
        comments.setUserId(userId);
        logger.info(" new Comment" + comments.toString());
        commentService.insertSelective(comments);
        // 更新动态评论值
        trendService.increaseCommentCount(comments.getTrendId());
        return R.success(null);
    }

}
