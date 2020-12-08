package me.cocode.jike.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("用户信息表 ")
@Table(name = "user_info")
public class UserInfo implements Serializable {
    /**
     * 用户主键 用户主键,与users.user_id对应
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("用户主键 用户主键,与users.user_id对应")
    private Integer id;

    /**
     * 性别 0为男1位女
     */
    @Column(name = "gender")
    @ApiModelProperty("性别 0为男1位女")
    private String gender;

    /**
     * 情感
     */
    @Column(name = "emotion")
    @ApiModelProperty("情感")
    private String emotion;

    /**
     * 生日
     */
    @Column(name = "birthday")
    @ApiModelProperty("生日")
    private String birthday;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gender=").append(gender);
        sb.append(", emotion=").append(emotion);
        sb.append(", birthday=").append(birthday);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}