package com.my;

import com.my.entity.TAccount;
import com.my.service.TAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@CrossOrigin
@RestController
public class MicroAccountApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MicroAccountApplication.class, args);
        String property = run.getEnvironment().getProperty("server.port");
        System.out.println("当前服务 端口为 ************" + property);
    }


    @Autowired
    private TAccountService tAccountService;

    @GetMapping("/getAccount/{userId}")
    public TAccount getAccount(@PathVariable String userId) {
        return tAccountService.getAccount(userId);
    }

}
