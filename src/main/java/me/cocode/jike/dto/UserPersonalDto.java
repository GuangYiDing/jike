package me.cocode.jike.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.cocode.jike.entity.UserInfo;

/**
 * 2020/12/7 08:47
 *
 * @author xiaodingsiren
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserPersonalDto  extends UserInfo{

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户头像
     */
    private String userAvatar;
    /**
     * 签名
     */
    private String signature;
    /**
     * 背景图
     */
    private String cover;

}
