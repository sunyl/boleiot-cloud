package com.boleiot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SysConfig {
    @Value("${sysfig.udpReceivePort}")
    private int UdpReceivePort;

    //线程池信息
    @Value("${sysfig.corePoolSize}")
    private int CorePoolSize;

    @Value("${sysfig.maxPoolSize}")
    private int MaxPoolSize;

    @Value("${sysfig.keepAliveSeconds}")
    private int KeepAliveSeconds;

    @Value("${sysfig.queueCapacity}")
    private int QueueCapacity;

    public int getCorePoolSize() {
        return CorePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        CorePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return MaxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        MaxPoolSize = maxPoolSize;
    }

    public int getKeepAliveSeconds() {
        return KeepAliveSeconds;
    }

    public void setKeepAliveSeconds(int keepAliveSeconds) {
        KeepAliveSeconds = keepAliveSeconds;
    }

    public int getQueueCapacity() {
        return QueueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        QueueCapacity = queueCapacity;
    }

    public int getUdpReceivePort() {
        return UdpReceivePort;
    }

    public void setUdpReceivePort(int udpReceivePort) {
        UdpReceivePort = udpReceivePort;
    }
}
