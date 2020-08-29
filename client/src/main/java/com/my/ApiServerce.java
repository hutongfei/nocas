package com.my;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "serve")
public interface ApiServerce {

    @GetMapping("/get/{id}")
    public String ServerApi(@PathVariable String id) ;
}
