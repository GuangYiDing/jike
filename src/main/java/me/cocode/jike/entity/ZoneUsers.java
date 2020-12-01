package me.cocode.jike.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("关注圈子列表 ")
@Table(name = "zone_users")
public class ZoneUsers implements Serializable {
    /**
     * 圈子用户主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("圈子用户主键")
    private Integer id;

    /**
     * 圈子主键
     */
    @Column(name = "zone_id")
    @ApiModelProperty("圈子主键")
    private Integer zoneId;

    /**
     * 用户主键
     */
    @Column(name = "user_id")
    @ApiModelProperty("用户主键")
    private Integer userId;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", zoneId=").append(zoneId);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}