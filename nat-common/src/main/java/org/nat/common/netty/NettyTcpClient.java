package org.nat.common.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyTcpClient {

    private final String host;
    private final Integer port;

    public NettyTcpClient(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public Channel connect(ChannelHandler channelHandler){
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup(1);
        Bootstrap bootstrap = new Bootstrap();
        Channel channel = bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(channelHandler)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .connect(host, port)
                .channel();
        return channel;
    }
}
