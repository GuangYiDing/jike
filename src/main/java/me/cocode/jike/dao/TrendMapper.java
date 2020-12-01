package me.cocode.jike.dao;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.dto.TrendDto;
import me.cocode.jike.entity.Trend;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TrendMapper extends CommonMapper<Trend> {

    @Select("SELECT t.id trendId,z.zone_name zoneName,z.avatar zoneAvatar,u.user_name userName,u.id userId,u.avatar userAvatar,t.images,t.content,t.likes_count likesCount,t.comments_count commentsCount,z.description,u.signature,t.create_time createTime FROM trend t INNER JOIN users u INNER JOIN zones z ON t.user_id=u.id AND t.zone_id=z.id ORDER BY create_time desc")
    @ResultType(TrendDto.class)
    List<TrendDto> getRecommendTrends();
}