package org.nat.common.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.List;

public class SimpleChannelInitializer extends ChannelInitializer<NioSocketChannel> {

    private final List<ChannelHandler> handlers;

    public SimpleChannelInitializer(List<ChannelHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    protected void initChannel(NioSocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(handlers.toArray(new ChannelHandler[0]));
    }
}
