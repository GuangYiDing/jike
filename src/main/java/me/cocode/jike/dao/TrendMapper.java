package me.cocode.jike.dao;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.dto.TrendDto;
import me.cocode.jike.entity.Follow;
import me.cocode.jike.entity.Trend;
import me.cocode.jike.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TrendMapper extends CommonMapper<Trend> {

    @Select("SELECT t.id trendId,z.zone_name zoneName,z.avatar zoneAvatar,u.user_name userName,u.id userId,u.avatar userAvatar,t.images,t.content,t.likes_count likesCount,t.comments_count commentsCount,z.description,u.signature,t.create_time createTime FROM trend t INNER JOIN users u INNER JOIN zones z ON t.user_id=u.id AND t.zone_id=z.id ORDER BY create_time desc")
    @ResultType(TrendDto.class)
    List<TrendDto> getRecommendTrends();

    @Select("SELECT t.id trendId,z.zone_name zoneName,z.avatar zoneAvatar,u.user_name userName,u.id userId,u.avatar userAvatar,t.images,t.content,t.likes_count likesCount,t.comments_count commentsCount,z.description,u.signature,t.create_time createTime FROM trend t INNER JOIN users u INNER JOIN zones z ON t.user_id=u.id AND t.zone_id=z.id WHERE t.id =#{trendId}")
    @ResultType(TrendDto.class)
    TrendDto getTrendById(@Param("trendId")Integer trendId);

    @Update("UPDATE trend " +
            "SET trend.comments_count=(SELECT comments_count FROM (" +
            "SELECT trend.comments_count FROM trend WHERE trend.id=#{trendId}) AS t)+1 WHERE trend.id=#{trendId}")
    int increaseCommentCount(@Param("trendId")Integer trendId);


    @Select("SELECT t.id trendId,z.zone_name zoneName,z.avatar zoneAvatar,u.user_name userName,u.id userId,u.avatar userAvatar,t.images,t.content,t.likes_count likesCount,t.comments_count commentsCount,t.create_time createTime FROM trend t INNER JOIN users u INNER JOIN zones z ON t.user_id=u.id AND t.zone_id=z.id WHERE u.id=#{userId} ORDER BY create_time DESC")
    @ResultType(TrendDto.class)
    List<TrendDto> getTrendByUserId(@Param("userId")Integer userId);

    /**
     * 获取已关注用户发布的动态
     */
    @Select("SELECT t.id trendId,z.zone_name zoneName,z.avatar zoneAvatar,u.user_name userName,u.id userId,u.avatar userAvatar,t.images,t.content,t.likes_count likesCount,t.comments_count commentsCount,t.create_time createTime FROM trend t INNER JOIN users u INNER JOIN zones z ON t.user_id=u.id AND t.zone_id=z.id WHERE u.id  in ( " +
            "SELECT following_user_id FROM follow WHERE follow.user_id=#{userId}) ORDER BY create_time DESC")
    List<TrendDto> getFollowingUserTrends(@Param("userId")Integer userId);




    @Delete("DELETE FROM trend WHERE trend.id= #{trendId}")
    int deletePostedTrend(@Param("trendId") Integer trendId);


    @Delete("DELETE FROM likes WHERE likes.trend_id = #{trendId}")
    int deletePostedTrendLikes(@Param("trendId") Integer trendId);

    @Delete("DELETE FROM comments WHERE comments.trend_id = #{trendId} ")
    int deletePostedTrendComm(@Param("trendId") Integer trendId);



}