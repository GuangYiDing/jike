package me.cocode.jike.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import me.cocode.jike.entity.Comments;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 2020/11/30 11:22
 *
 * @author xiaodingsiren
 */
@Data
public class CommentDto   {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 评论id
     */
    private String commId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户头像
     */
    private String userAvatar;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 点赞数
     */
    private Integer likesCount;
    /**
     * 评论图像
     */
    private String images;
    /**
     * 父节点
     */
    private Integer parentId;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private String createTime;



}
