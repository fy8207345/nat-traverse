package org.nat.server.config;

import lombok.extern.slf4j.Slf4j;
import org.nat.server.bootstrap.ServerTcpListener;
import org.nat.server.bootstrap.UpstreamConnector;
import org.nat.server.domain.Node;
import org.nat.server.handler.NatServerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class NatServerConfiguration {

    @Bean(initMethod = "start")
    public ServerTcpListener nodeTcpListenerStarter(Node node){
        return new ServerTcpListener(node.getPort(), new NatServerHandler());
    }

    @Bean(initMethod = "connect")
    public UpstreamConnector upstreamConnector(Node node){
        return new UpstreamConnector(node);
    }
}
