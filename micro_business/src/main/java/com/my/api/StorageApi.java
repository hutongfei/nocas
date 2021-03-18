package com.my.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author hutf
 * @createTime 2021年03月18日 18:02:00
 */
@Component
@FeignClient(value = "micro_storage")
public class StorageApi {
}
