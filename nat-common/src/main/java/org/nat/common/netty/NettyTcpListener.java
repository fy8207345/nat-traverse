package org.nat.common.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyTcpListener {

    private final int port;
    private Channel channel;

    public NettyTcpListener(int port) {
        this.port = port;
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
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline
                                .addLast(new IdleStateHandler(30, 30, 30));
                    }
                })
                .bind(port)
        .channel();
        log.info("tcp server started at : 0.0.0.0:{}", port);
    }
}
