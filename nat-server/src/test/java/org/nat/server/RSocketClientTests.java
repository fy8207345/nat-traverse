package org.nat.server;

import io.rsocket.RSocket;
import io.rsocket.core.RSocketConnector;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.client.TcpClientTransport;

import java.time.Duration;

public class RSocketClientTests {

    public static void main(String[] args) {
        RSocket rSocket = RSocketConnector.create()
                .payloadDecoder(PayloadDecoder.ZERO_COPY)
                .connect(TcpClientTransport.create(7878))
                .block();
        rSocket.onClose()
                .block();
    }
}
