package me.cocode.jike.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import me.cocode.jike.netty.Enum.ChatMessageTypeEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * 2021/5/14 下午12:15
 *
 * @author xiaodingsiren
 */
@Data
@ToString
@AllArgsConstructor
public class ChatVo implements Serializable {
    /**
     * 消息id
     */
    private Integer id;
    /**
     * 发送方
     */
    private Integer fromUserId;
    /**
     * 接收方
     */
    private Integer toUserId;
    /**
     * 消息内容
     */
    private String messageContent;

    /**
     * 聊天消息类型 ChatMessageTypeEnum
     * TEXT("text"),
     * IMAGE("image"),
     * HEART("heart")
     */
    private String chatMessageType;
    /**
     * 发送时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date dateTime;
}
