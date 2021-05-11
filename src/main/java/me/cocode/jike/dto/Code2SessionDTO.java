package me.cocode.jike.dto;

import lombok.Data;

/**
 * 2021/5/11 下午3:54
 *
 * @author xiaodingsiren
 */
@Data
public class Code2SessionDTO {
    private String openid;
    private String session_key;
    private String unionid;
    private String errcode = "0";
    private String errmsg;
    private int expires_in;
}
