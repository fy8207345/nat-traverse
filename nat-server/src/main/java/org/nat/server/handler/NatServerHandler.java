package org.nat.server.handler;

import io.netty.buffer.ByteBufUtil;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.netty.NettyInbound;
import reactor.netty.NettyOutbound;

import java.util.function.BiFunction;

@Slf4j
public class NatServerHandler {

    public BiFunction<? super NettyInbound, ? super NettyOutbound, ? extends Publisher<Void>> handle(){
        return (nettyInbound, nettyOutbound) -> {
            nettyInbound.withConnection(connection -> {
                connection.inbound()
                        .receive()
                        .subscribe(byteBuf -> {
                            StringBuilder stringBuilder = new StringBuilder();
                            ByteBufUtil.appendPrettyHexDump(stringBuilder, byteBuf);
                            log.info("connection {} received packet: \n {}", connection, stringBuilder);
                        });
            });
          return nettyOutbound.neverComplete();
        };
    }
}
