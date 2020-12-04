package me.cocode.jike.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ApiModel("动态表 ")
@Table(name = "trend")
public class Trend implements Serializable {
    /**
     * 动态主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("动态主键")
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 动态内容
     */
    @Column(name = "content")
    @ApiModelProperty("动态内容")
    private String content;

    /**
     * 动态图片 动态中的图片路径列表
     */
    @Column(name = "images")
    @ApiModelProperty("动态图片 动态中的图片路径列表")
    private String images;

    /**
     * 发布时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("发布时间")
    private Date createTime;

    /**
     * 圈子id
     */
    @Column(name = "zone_id")
    @ApiModelProperty("圈子id")
    private Integer zoneId;




    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", content=").append(content);
        sb.append(", images=").append(images);
        sb.append(", createTime=").append(createTime);
        sb.append(", zoneId=").append(zoneId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}