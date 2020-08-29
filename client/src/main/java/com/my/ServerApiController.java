package com.my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class ServerApiController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${desc}")
    private String desc;

    @Autowired
    private ApiServerce apiServerce;

    @Value("${server.port}")
    private String port;

    @GetMapping("/get/{id}")
    public String get(@PathVariable String id) {
        return apiServerce.ServerApi(id);
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
