package edu.nju.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by cuihao on 2016/7/22.
 */
@Component
public class HostConfig {

    @Value("${ruanhu.server.address}")
    private String ipAddress;

    @Value("${ruanhu.server.port}")
    private int port;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
