package me.cocode.jike.service;

import me.cocode.jike.common.service.CommonService;
import me.cocode.jike.dto.PostTrendDto;
import me.cocode.jike.dto.TrendDto;
import me.cocode.jike.entity.Trend;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 2020/11/27 08:09
 *
 * @author xiaodingsiren
 */
public interface TrendService extends CommonService<Trend> {

    /**
     * 发布动态 通过dto 构建Trend
     * @param dto 前端提交的dto
     * @return 构建完成的 trend
     */
    Trend postTrend(PostTrendDto dto);

    List<TrendDto> getRecommendTrends();

}
