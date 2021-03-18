package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroStorageApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MicroStorageApplication.class, args);
        String property = run.getEnvironment().getProperty("server.port");
        System.out.println("当前服务 端口为 ************" + property);
    }

}
