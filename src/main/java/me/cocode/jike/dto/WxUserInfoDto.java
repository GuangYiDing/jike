package me.cocode.jike.dto;

import lombok.Data;

/**
 * 2021/5/11 下午7:14
 *
 * @author xiaodingsiren
 */
@Data
public class WxUserInfoDto {
    String nickName;
    String avatarUrl;
    Integer gender;
    String language;
    String city;
    String province;
    String country;
}
