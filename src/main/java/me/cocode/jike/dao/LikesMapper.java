package me.cocode.jike.dao;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.entity.Likes;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface LikesMapper extends CommonMapper<Likes> {
    /**
     * 点赞动态
     */
    @Update("UPDATE trend " +
            "SET trend.likes_count=(SELECT likes_count FROM ( " +
            "SELECT trend.likes_count FROM trend WHERE trend.id=#{trendId}) AS t)+1 WHERE trend.id=#{trendId}")
    int increaseTrendLikesCount(@Param("trendId")Integer trendId);


    /**
     * 点赞评论
     */
    @Update("UPDATE comments " +
            "SET comments.likes_count=(SELECT likes_count FROM ( " +
            "SELECT comments.likes_count FROM comments WHERE comments.id=#{commId}) AS t)+1 WHERE comments.id=#{commId}")
    int increaseCommLikesCount(@Param("commId")Integer commId);
}