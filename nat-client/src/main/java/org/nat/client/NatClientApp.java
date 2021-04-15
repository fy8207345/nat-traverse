package org.nat.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.security.krb5.internal.NetClient;

@SpringBootApplication
public class NatClientApp {

    public static void main(String[] args) {
        SpringApplication.run(NetClient.class, args);
    }
}
