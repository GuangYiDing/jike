package me.cocode.jike.netty;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author guangyi
 * @Description 绑定用户id和channel的实时Map
 * @Date 2021/5/14 下午12:43
 */
@Slf4j
public class UserChannelRel {
    /**
     * 用户id为键，channel为值
     */
    private static ConcurrentHashMap<Integer, Channel> manager = new ConcurrentHashMap<>();

    /**
     * 添加客户端与channel绑定
     */
    public static void put(Integer senderId, Channel channel) {
        manager.put(senderId, channel);
    }

    /**
     * 根据用户id查询
     */
    public static Channel get(Integer senderId) {
        return manager.get(senderId);
    }

    /**
     * 根据用户id，判断是否存在此客户端（即客户端是否在线）
     */
    public static boolean isContainsKey(Integer userId) {
        return manager.containsKey(userId);
    }

    /**
     * 输出
     */
    public static void output() {
        manager.forEach((key, value) -> log.info("UserId: {} ,ChannelId: {}", key,
                value.id().asLongText()));
    }
}
