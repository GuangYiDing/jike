package me.cocode.jike.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("消息通知表 ")
@Table(name = "notify")
public class Notify implements Serializable {
    /**
     * 通知主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("通知主键")
    private Integer id;

    /**
     * 消费者
     */
    @Column(name = "to_user_id")
    @ApiModelProperty("消费者")
    private Integer toUserId;

    /**
     * 生产者
     */
    @Column(name = "from_user_id")
    @ApiModelProperty("生产者")
    private Integer fromUserId;

    /**
     * 通知时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("通知时间")
    private Date createTime;

    /**
     * 是否消费
     */
    @Column(name = "is_confirmed")
    @ApiModelProperty("是否消费")
    private String isConfirmed;

    /**
     * 消息内容
     */
    @Column(name = "message")
    @ApiModelProperty("消息内容")
    private String message;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", toUserId=").append(toUserId);
        sb.append(", fromUserId=").append(fromUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", isConfirmed=").append(isConfirmed);
        sb.append(", message=").append(message);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}