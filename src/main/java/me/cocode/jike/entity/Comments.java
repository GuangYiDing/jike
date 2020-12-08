package me.cocode.jike.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("动态评论表 ")
@Table(name = "comments")
public class Comments implements Serializable {
    /**
     * 评论主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("评论主键")
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
     * 评论内容
     */
    @Column(name = "content")
    @ApiModelProperty("评论内容")
    private String content;

    /**
     * 发布时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("发布时间")
    private Date createTime;

    /**
     * 父节点
     */
    @Column(name = "parent_id")
    @ApiModelProperty("父节点")
    private Integer parentId;

    /**
     * 点赞数
     */
    @Column(name = "likes_count")
    @ApiModelProperty("点赞数")
    private Integer likesCount;

    /**
     * 评论图
     */
    @Column(name = "images")
    @ApiModelProperty("评论图")
    private String images;

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
        sb.append(", content=").append(content);
        sb.append(", createTime=").append(createTime);
        sb.append(", parentId=").append(parentId);
        sb.append(", likesCount=").append(likesCount);
        sb.append(", images=").append(images);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}