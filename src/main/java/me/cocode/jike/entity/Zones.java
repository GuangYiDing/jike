package me.cocode.jike.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("圈子表 ")
@Table(name = "zones")
public class Zones implements Serializable {
    /**
     * 圈子主键 圈子表主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("圈子主键 圈子表主键")
    private Integer id;

    /**
     * 头像 头像路径
     */
    @Column(name = "avatar")
    @ApiModelProperty("头像 头像路径")
    private String avatar;

    /**
     * 描述 圈子描述
     */
    @Column(name = "description")
    @ApiModelProperty("描述 圈子描述")
    private String description;

    /**
     * 名称
     */
    @Column(name = "zone_name")
    @ApiModelProperty("名称")
    private String zoneName;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", avatar=").append(avatar);
        sb.append(", description=").append(description);
        sb.append(", zoneName=").append(zoneName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}