package me.cocode.jike.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.cocode.jike.common.cro.R;
import me.cocode.jike.common.cro.ResultCode;
import me.cocode.jike.dto.CommentDto;
import me.cocode.jike.dto.PostCommDto;
import me.cocode.jike.entity.Comments;
import me.cocode.jike.security.JwtUtils;
import me.cocode.jike.service.CommentService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
import java.util.Map;

/**
 * 2020/11/30 15:18
 *
 * @author xiaodingsiren
 */
@RestController
@RequestMapping("/comm")
@Api(tags = "评论管理")
public class CommentController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommentService commentService;


    @GetMapping
    @ApiOperation("获取动态评论")
    public R<List<CommentDto>> getComm(@RequestParam("trendId") Integer trendId){
        return R.success(commentService.getCommByTrendId(trendId));
    }

    @PostMapping
    @RequiresAuthentication
    @ApiOperation("发布评论")
    public R postComment(@RequestBody String postCommJson,@RequestHeader("Authorization") String token){
        PostCommDto postCommDto = JSON.parseObject(postCommJson, PostCommDto.class);
        logger.debug("Dto => "+ postCommDto.toString());
        return R.success(postCommDto);
    }

}
