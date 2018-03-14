package com.jk.service.login;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider-log")
public interface LoginService {

    @RequestMapping("/log/insertLog")
    void saveLog(@RequestParam(value = "log") String log);
}
