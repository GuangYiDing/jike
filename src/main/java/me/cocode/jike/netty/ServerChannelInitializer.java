package me.cocode.jike.netty;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.CharsetUtil;


/**
 * 2021/5/12 下午11:07
 *
 * @author xiaodingsiren
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //web基于http协议的解码器
        socketChannel.pipeline().addLast(new HttpServerCodec());
        // 对大数据流的支持
        socketChannel.pipeline().addLast(new ChunkedWriteHandler());
        //对http message进行聚合，聚合成FullHttpRequest或FullHttpResponse
        socketChannel.pipeline().addLast(new HttpObjectAggregator(1024 * 64));
        //websocket服务器处理对协议，用于指定给客户端连接访问的路径
        //该handler会帮你处理一些繁重的复杂的事
        //会帮你处理握手动作：handshaking(close,ping,pong) ping + pong = 心跳
        //对于websocket来讲，都是以frames进行传输的，不同的数据类型对应的frames也不同
        socketChannel.pipeline().addLast(new WebSocketServerProtocolHandler("/ws"));
        //添加编解码
        socketChannel.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
        socketChannel.pipeline().addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
        socketChannel.pipeline().addLast(new NettyServerHandler());
    }

}
