package me.cocode.jike.vo;

import cn.hutool.core.date.DateTime;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.cocode.jike.netty.Enum.MsgActionTypeEnum;
import me.cocode.jike.netty.Enum.MsgSignFlagEnum;

/**
 * @author guangyi
 * @Description 消息封装VO
 * @Date 2021/5/14 下午12:31
 */
@Data
@AllArgsConstructor
public class MessageVo {

    /**
     * 动作类型 msgActionTypeEnum.getType()
     *  CONNECT(1,"第一次(或重连)初始化连接"),
     *  CHAT(2,"聊天消息"),
     *  KEEPALIVE(3,"保持心跳"),
     *  Notify(4,"通知消息")
     */
    private Integer msgActionType;
    /**
     * 消息签收状态
     * SIGNED(1,"已签收");
     * UNSIGNED(0,"未签收"),
     */
    private Integer msgSignFlag;

    private ChatVo chatVo;

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new MessageVo(1,1,new ChatVo(1,1,1,
                "hello","text",new DateTime()))));
    }
}
