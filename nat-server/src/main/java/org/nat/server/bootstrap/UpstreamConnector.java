package org.nat.server.bootstrap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import lombok.extern.slf4j.Slf4j;
import org.nat.common.netty.NettyTcpClient;
import org.nat.common.netty.SimpleChannelInitializer;
import org.nat.server.domain.Node;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UpstreamConnector {

    private final Node node;

    public UpstreamConnector(Node node) {
        this.node = node;
    }

    public void connect(){
        if(StringUtils.hasText(node.getUpStreamHost()) && node.getUpStreamPort() != null){
            log.info("starting connect to upstream : {}:{}", node.getUpStreamHost(), node.getUpStreamPort());
            List<ChannelHandler> channelHandlers = new ArrayList<>();
            SimpleChannelInitializer simpleClientChannelInitializer = new SimpleChannelInitializer(channelHandlers);
            NettyTcpClient nettyTcpClient = new NettyTcpClient(node.getHost(), node.getPort());
            Channel channel = nettyTcpClient.connect(simpleClientChannelInitializer);
            log.info("node connected to upstream : {}", channel);
        } else {
            log.info("upstream not configured. stopping connect to upstream!");
        }
    }
}
