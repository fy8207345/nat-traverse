package org.nat.server.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 部署节点：表示一个server节点
 */
@Configuration
@ConfigurationProperties(prefix = "node")
@Getter
@Setter
public class Node {

    /**
     * 节点id
     */
    private String id;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 节点主机
     */
    private String host;

    /**
     * 本机监听
     */
    private Integer port;

    /**
     * 上游ip或者域名
     */
    private String upStreamHost;

    /**
     * 上游tcp端口
     */
    private Integer upStreamPort;

}
