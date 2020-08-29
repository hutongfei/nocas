package com.my;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ServerApplication {

    @Value("${server.port}")
    private String port;

    @Value("${desc}")
    private String desc;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ServerApplication.class, args);
        String property = run.getEnvironment().getProperty("server.port");
        System.out.println("current Thread port is *********************************************************" + property);
    }

    @GetMapping("/getPort")
    public String getPort() {
        return "当前服务器端口为  "+port;
    }

    @GetMapping("/getDesc")
    public String getDesc() {
        return  desc;
    }

}
