package me.cocode.jike.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
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
     * 背景图 用户名片背景图
     */
    @Column(name = "cover")
    @ApiModelProperty("背景图 用户名片背景图")
    private String cover;

    /**
     * 性别 0为男1位女
     */
    @Column(name = "female")
    @ApiModelProperty("性别 0为男1位女")
    private String female;

    /**
     * 情感 用户的情感状态
     */
    @Column(name = "bachelor")
    @ApiModelProperty("情感 用户的情感状态")
    private String bachelor;

    /**
     * 生日 用户生日
     */
    @Column(name = "birthday")
    @ApiModelProperty("生日 用户生日")
    private Date birthday;

    /**
     * 所在地 用户所在地
     */
    @Column(name = "location")
    @ApiModelProperty("所在地 用户所在地")
    private String location;

    /**
     * 学校 所在学校
     */
    @Column(name = "school")
    @ApiModelProperty("学校 所在学校")
    private String school;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cover=").append(cover);
        sb.append(", female=").append(female);
        sb.append(", bachelor=").append(bachelor);
        sb.append(", birthday=").append(birthday);
        sb.append(", location=").append(location);
        sb.append(", school=").append(school);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}