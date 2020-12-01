package me.cocode.jike.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("关注表 显示用户间的关注信息")
@Table(name = "follow")
public class Follow implements Serializable {
    /**
     * 关注主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("关注主键")
    private Integer id;

    /**
     * 用户主键
     */
    @Column(name = "user_id")
    @ApiModelProperty("用户主键")
    private Integer userId;

    /**
     * 关注的用户id
     */
    @Column(name = "following_user_id")
    @ApiModelProperty("关注的用户id")
    private Integer followingUserId;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", followingUserId=").append(followingUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}