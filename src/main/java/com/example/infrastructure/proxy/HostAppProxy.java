package com.example.infrastructure.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(value = "hostapp", url = "http://localhost:8099/")
public interface HostAppProxy {
    @RequestMapping(method = POST, value = "/charge")
    ResponseEntity<String> charge();
}
