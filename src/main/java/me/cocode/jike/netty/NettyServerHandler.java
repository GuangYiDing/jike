package me.cocode.jike.netty;

import cn.hutool.core.date.DateTime;
import com.alibaba.fastjson.JSON;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
import me.cocode.jike.netty.Enum.ChatMessageTypeEnum;
import me.cocode.jike.netty.Enum.MsgActionTypeEnum;
import me.cocode.jike.vo.ChatVo;
import me.cocode.jike.vo.MessageVo;

import java.net.InetSocketAddress;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 2021/5/12 下午11:08
 *
 * @author xiaodingsiren
 */

@Slf4j
public class NettyServerHandler extends SimpleChannelInboundHandler<Object> {


    /**
     * 客户端组 用于记录和管理所有客户端的channel
     */
    public static ChannelGroup channelGroup;

    static {
        channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    }

    /**
     * 客户端连接会触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("Channel active......");
    }

    /**
     * 客户端发消息会触发
     */
    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("服务器收到消息: {}", msg.toString());
        Channel currentChannel = ctx.channel();
        // 文本消息
        if (msg instanceof TextWebSocketFrame) {
            String messageStr = ((TextWebSocketFrame) msg).text();
            log.info("收到客户端消息: {}",messageStr);
            // 转化json为javabean
            MessageVo messageVo = JSON.toJavaObject(JSON.parseObject(messageStr),MessageVo.class);
            ChatVo chatVo = messageVo.getChatVo();
            // 获取消息的操作类型
            Integer msgActionType = messageVo.getMsgActionType();
            // 第一次连接成功后,给客户端发消息
            if (msgActionType.equals(MsgActionTypeEnum.CONNECT.getType())) {
                // 初始化channel,将当前channel 和userId 关联起来
                Integer fromUserId = chatVo.getFromUserId();
                UserChannelRel.put(fromUserId,currentChannel);
            }else if (msgActionType.equals(MsgActionTypeEnum.CHAT.getType())){
                // 聊天类型的消息，把聊天记录保存到redis，同时标记消息的签收状态[是否签收]
                Integer toUserId = chatVo.getToUserId();
                // 设置发送时间
                chatVo.setDateTime(new DateTime());
                //判断消息是否符合定义的类型
                if (ChatMessageTypeEnum.verifyChatType(chatVo.getChatMessageType())){
                    //发送消息给指定用户
                    if (toUserId>0 && UserChannelRel.isContainsKey(toUserId)){
                        sendMessage(toUserId,JSON.toJSONString(chatVo));
                    }
                }
            }else if (msgActionType.equals(MsgActionTypeEnum.KEEPALIVE.getType())){
                log.info("收到来自channel 为:{} 心跳包",currentChannel);
            }
        }
        //二进制消息
        if (msg instanceof BinaryWebSocketFrame) {
            log.info("收到二进制消息：{}", ((BinaryWebSocketFrame) msg).content().readableBytes());
            BinaryWebSocketFrame binaryWebSocketFrame = new BinaryWebSocketFrame(Unpooled.buffer().writeBytes("hello".getBytes()));
            //给客户端发送的消息
            ctx.channel().writeAndFlush(binaryWebSocketFrame);
        }
        //ping消息
        if (msg instanceof PongWebSocketFrame) {
            System.out.println("客户端ping成功");
        }
        //关闭消息
        if (msg instanceof CloseWebSocketFrame) {
            System.out.println("客户端关闭，通道关闭");
            Channel channel = ctx.channel();
            channel.close();
        }
    }


    /**
     * 当客户端连接服务端之后(打开连接)
     * 获取客户端的channel,并且放到ChannelGroup中去进行管理
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channelGroup.add(ctx.channel());
    }


    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端断开连接,channel 对应长id为: {}", ctx.channel().id().asLongText());
        log.info("客户端断开连接,channel 对应短id为: {}", ctx.channel().id().asShortText());
    }

    /**
     * 发生异常触发
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("连接异常: {}", cause.getMessage());
        ctx.channel().close();
        channelGroup.remove(ctx.channel());
    }

    /**
     * 给指定用户发内容
     * @param userId
     * @param msg
     */
    public static  void sendMessage(Integer userId,String msg){
        Channel toUserChannel = UserChannelRel.get(userId);
        toUserChannel.writeAndFlush(new TextWebSocketFrame(msg));
    }

    /**
     * 广播消息
     * @param msg
     */
    public static void sendAll(String msg){
        channelGroup.writeAndFlush(new TextWebSocketFrame(msg));
    }



}
