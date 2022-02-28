package me.cocode.jike.netty.Enum;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 2021/5/14 下午12:21
 * 聊天信息类型
 * @author xiaodingsiren
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ChatMessageTypeEnum {
    /**
     * 文本
     */
    TEXT("text"),
    /**
     * 图片
     */
    IMAGE("image"),
    /**
     * 心跳包
     */
    HEART("heart")
    ;
    @Getter
    private String chatType;

    /**
     * 检验聊天消息类型
     * @param chatType
     * @return
     */
    public static boolean verifyChatType(String chatType){
            for (ChatMessageTypeEnum typeEnum :ChatMessageTypeEnum.values()){
                if (StrUtil.isNotBlank(chatType)&&chatType.equals(typeEnum.getChatType())){
                    return  true;
                }
            }
            return false;
    }
}


