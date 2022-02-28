package me.cocode.jike.netty.Enum;

import lombok.Getter;

/**
 * @author guangyi
 * @Description 消息是否签收
 * @Date 2021/5/14 下午12:34
 */
public enum MsgSignFlagEnum {

    /**
     * 未签收
     */
    UNSIGNED(0,"未签收"),
    /**
     * 已签收
     */
    SIGNED(1,"已签收");


    @Getter
    private final int type;
    @Getter
    private final String value;

    MsgSignFlagEnum(int type, String value) {
        this.type = type;
        this.value = value;
    }
}
