package org.nat.server;


import io.rsocket.core.RSocketServer;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.server.TcpServerTransport;
import reactor.core.publisher.Mono;

public class RSocketServerTests {

    public static void main(String[] args) throws InterruptedException {
        RSocketServer.create()
                .payloadDecoder(PayloadDecoder.ZERO_COPY)
                .bind(TcpServerTransport.create(7878))
                .block()
                .onClose()
                .block();
    }
}
