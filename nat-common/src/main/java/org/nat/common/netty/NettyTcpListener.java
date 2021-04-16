package org.nat.common.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyTcpListener {

    private final int port;
    private ChannelHandler channelHandler;
    private Channel channel;

    public NettyTcpListener(int port, ChannelHandler channelHandler) {
        this.port = port;
        this.channelHandler = channelHandler;
    }

    public Channel getChannel() {
        return channel;
    }

    public void start(){
        EventLoopGroup parent = new NioEventLoopGroup(1);
        EventLoopGroup child = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        channel = serverBootstrap.group(parent, child)
                .channel(NioServerSocketChannel.class)
                .childHandler(channelHandler)
                .bind(port)
        .channel();
        log.info("tcp server started at : 0.0.0.0:{}", port);
    }
}
