package org.nat.server.bootstrap;

import io.netty.channel.ChannelHandler;
import org.nat.common.netty.NettyTcpListener;

public class ServerTcpListener extends NettyTcpListener {
    public ServerTcpListener(int port, ChannelHandler channelHandler) {
        super(port, channelHandler);
    }
}
