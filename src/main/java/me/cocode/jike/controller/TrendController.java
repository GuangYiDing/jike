package me.cocode.jike.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.cocode.jike.common.cro.R;
import me.cocode.jike.common.cro.ResultCode;
import me.cocode.jike.dto.PostTrendDto;
import me.cocode.jike.dto.TrendDto;
import me.cocode.jike.entity.Trend;
import me.cocode.jike.security.JwtUtils;
import me.cocode.jike.service.TrendService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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



    @PostMapping
    @RequiresAuthentication
    @ApiOperation("发布动态")
    public ResultCode postTrend(@RequestBody String trendJson,@RequestHeader("Authorization") String token){
        PostTrendDto postTrendDto = JSON.parseObject(trendJson, PostTrendDto.class);
        Integer userId = JwtUtils.getUserId(token);
        logger.info("Dto => "+ postTrendDto.toString());
        Trend trend = trendService.postTrend(postTrendDto);
        trend.setUserId(userId);
        logger.info("trend => " + trend.toString());
        trendService.insert(trend);
        return ResultCode.SUCCESS;
    }


    @GetMapping("/recommend")
    @ApiOperation("获取推荐动态")
    public R<List<TrendDto>> getRecommend(){
        return R.success(trendService.getRecommendTrends());

    }


}
