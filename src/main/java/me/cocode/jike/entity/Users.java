package me.cocode.jike.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@ApiModel("用户表 用户表,主要存贮访问频次最高的信息")
@Table(name = "users")
public class Users implements Serializable {
    /**
     * 用户主键 用户唯一主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("用户主键 用户唯一主键")
    private Integer id;

    /**
     * 用户名 用户昵称
     */
    @Column(name = "user_name")
    @ApiModelProperty("用户名 用户昵称")
    private String userName;

    /**
     * 头像
     */
    @Column(name = "avatar")
    @ApiModelProperty("头像")
    private String avatar;

    /**
     * 签名
     */
    @Column(name = "signature")
    @ApiModelProperty("签名")
    private String signature;

    /**
     * 密码 用户密码
     */
    @Column(name = "password")
    @ApiModelProperty("密码 用户密码")
    private String password;

    /**
     * 角色
     */
    @Column(name = "role")
    @ApiModelProperty("角色")
    private String role;

    /**
     * 权限
     */
    @Column(name = "permission")
    @ApiModelProperty("权限")
    private String permission;

    /**
     * 关注数
     */
    @Column(name = "following")
    @ApiModelProperty("关注数")
    private Integer following;

    /**
     * 被关注数
     */
    @Column(name = "followed")
    @ApiModelProperty("被关注数")
    private Integer followed;

    /**
     * 背景图
     */
    @Column(name = "cover")
    @ApiModelProperty("背景图")
    private String cover;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", avatar=").append(avatar);
        sb.append(", signature=").append(signature);
        sb.append(", password=").append(password);
        sb.append(", role=").append(role);
        sb.append(", permission=").append(permission);
        sb.append(", following=").append(following);
        sb.append(", followed=").append(followed);
        sb.append(", cover=").append(cover);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}