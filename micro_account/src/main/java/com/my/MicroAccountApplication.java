package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MicroAccountApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MicroAccountApplication.class, args);
        String property = run.getEnvironment().getProperty("server.port");
        System.out.println("当前服务 端口为 ************" + property);
    }

}
