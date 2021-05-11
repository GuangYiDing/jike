package me.cocode.jike.dto;

import lombok.Data;

/**
 * 2021/5/11 下午5:25
 *
 * @author xiaodingsiren
 */
@Data
public class MpLoginCallBackDto {
    String code;
    WxUserInfoDto wxUserInfoDto;
}
