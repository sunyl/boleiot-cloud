package com.boleiot.event;

import com.boleiot.config.SysConfig;
import com.boleiot.udp.UdpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class StartupEvent implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger log = LoggerFactory.getLogger(StartupEvent.class);

    private static ApplicationContext context;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        try {
            context = contextRefreshedEvent.getApplicationContext();
            SysConfig sysConfig = context.getBean(SysConfig.class);
            UdpServer udpServer = (UdpServer) StartupEvent.getBean(UdpServer.class);
            udpServer.run(sysConfig.getUdpReceivePort());

        } catch (Exception e) {
            log.error("Exception", e);
        }
    }

    public static Object getBean(Class beanName) {
        return context != null ? context.getBean(beanName) : null;
    }
}
