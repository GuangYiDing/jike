package me.cocode.jike.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("动态点赞表 ")
@Table(name = "likes")
public class Likes implements Serializable {
    /**
     * 点赞主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("点赞主键")
    private Integer id;

    /**
     * 动态id
     */
    @Column(name = "trend_id")
    @ApiModelProperty("动态id")
    private Integer trendId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 评论id
     */
    @Column(name = "comment_id")
    @ApiModelProperty("评论id")
    private Integer commentId;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", trendId=").append(trendId);
        sb.append(", userId=").append(userId);
        sb.append(", commentId=").append(commentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}