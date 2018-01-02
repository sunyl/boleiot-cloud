package com.boleiot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@EnableAsync
@EnableScheduling
public class BoleiotCloudMessageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoleiotCloudMessageServiceApplication.class, args);
    }

}
