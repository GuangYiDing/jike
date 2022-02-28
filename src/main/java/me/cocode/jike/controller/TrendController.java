package me.cocode.jike.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.cocode.jike.common.cro.R;
import me.cocode.jike.common.cro.ResultCode;
import me.cocode.jike.dao.TrendMapper;
import me.cocode.jike.dto.PostTrendDto;
import me.cocode.jike.dto.TrendDto;
import me.cocode.jike.entity.Trend;
import me.cocode.jike.security.JwtUtils;
import me.cocode.jike.service.TrendService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 2020/11/26 22:44
 * 动态管理
 * @author xiaodingsiren
 */
@RestController
@RequestMapping("/trend")
@Api(tags = "动态管理")
public class TrendController {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TrendService trendService;
    @Autowired
    private TrendMapper trendMapper;


    @PostMapping
    @RequiresAuthentication
    @Transactional(rollbackFor=Exception.class)
    @ApiOperation("发布动态")
    public ResultCode postTrend(@RequestBody String trendJson,@RequestHeader("Authorization") String token){
        PostTrendDto postTrendDto = JSON.parseObject(trendJson, PostTrendDto.class);
        Integer userId = JwtUtils.getUserId(token);
        logger.info("Dto => "+ postTrendDto.toString());
        Trend trend = trendService.postTrend(postTrendDto);
        trend.setUserId(userId);
        logger.info("trend => " + trend.toString());
        trendService.insertSelective(trend);
        return ResultCode.SUCCESS;
    }


    @GetMapping("/recommend")
    @ApiOperation("获取推荐动态")
    public R<List<TrendDto>> getRecommend(){
        return R.success(trendService.getRecommendTrends());

    }

    @GetMapping
    @ApiOperation("根据主键获取动态详情")
    public R<TrendDto> getTrendById(@RequestParam("trendId") Integer trendId){
        return R.success(trendService.getTrendById(trendId));
    }


    @GetMapping("/personal")
    @ApiOperation("获取用户自己的动态")
    @RequiresAuthentication
    public R<List<TrendDto>>  getUserPersonalTrend(){
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());
        return R.success(trendMapper.getTrendByUserId(userId));
    }


    @GetMapping("/others")
    @ApiOperation("获取其他用户的动态")
    public R<List<TrendDto>>  getUserPersonalTrend(@RequestParam("userId")Integer userId){
        return R.success(trendMapper.getTrendByUserId(userId));
    }

    @GetMapping("/following")
    @RequiresAuthentication
    @ApiOperation("获取已关注用户的动态")
    public R<List<TrendDto>>  getFollowingUserTrends(){
        Subject subject = SecurityUtils.getSubject();
        Integer userId = JwtUtils.getUserId(subject.getPrincipals().toString());
        return R.success(trendMapper.getFollowingUserTrends(userId));
    }


    @DeleteMapping("/profile")
    @RequiresAuthentication
    @Transactional(rollbackFor=Exception.class)
    @ApiOperation("删除档案中的动态")
    public R deleteProfileTrend(@RequestParam("trendId") Integer trendId){
        trendMapper.deletePostedTrend(trendId);
        trendMapper.deletePostedTrendLikes(trendId);
        trendMapper.deletePostedTrendComm(trendId);
        return  R.success(null);
    }

}
