package org.nat.server.bootstrap;

import org.nat.common.netty.NettyTcpListener;
import org.nat.server.domain.Node;

public class ServerTcpListener extends NettyTcpListener {

    public ServerTcpListener(int port) {
        super(port);
    }
}
