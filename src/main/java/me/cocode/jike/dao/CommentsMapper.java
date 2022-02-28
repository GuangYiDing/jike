package me.cocode.jike.dao;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.dto.CommentDto;
import me.cocode.jike.entity.Comments;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentsMapper extends CommonMapper<Comments> {
    /**
     * 根据动态id获取评论
     */
    @Select("SELECT u.id userId,u.user_name userName,u.avatar userAvatar,c.create_time createTime,c.likes_count likesCount,c.content,c.images,c.id commId,c.parent_id parentId FROM comments AS c INNER JOIN users AS u ON c.user_id=u.id AND c.trend_id=#{id} ORDER BY create_time desc")
    @ResultType(CommentDto.class)
    List<CommentDto> getCommByTrendId(Integer trendId);

    /**
     * 删除用户所有的评论
     */
    @Delete("DELETE FROM  comments WHERE comments.user_id=#{userId}")
    int deleteUsersComments(@Param("userId") Integer userId);
}