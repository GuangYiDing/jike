package me.cocode.jike.netty.Enum;

import lombok.Getter;

/**
 * @author guangyi
 * @Description 消息操作类型
 * @Date 2021/5/14 下午12:33
 */
public enum MsgActionTypeEnum {
    /**
     * 第一次连接
     */
    CONNECT(1,"第一次(或重连)初始化连接"),
    /**
     * 聊天消息
     */
    CHAT(2,"聊天消息"),
    /**
     * 保持心跳
     */
    KEEPALIVE(3,"保持心跳"),
    /**
     * 通知消息
     */
    Notify(4,"通知消息")
    ;
    @Getter
    private final Integer type;
    @Getter
    private final String content;

    MsgActionTypeEnum(Integer type, String content) {
        this.type = type;
        this.content = content;
    }
}
