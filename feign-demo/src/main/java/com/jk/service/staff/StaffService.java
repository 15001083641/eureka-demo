package com.jk.service.staff;

import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "provider-log")
public interface StaffService {

    @RequestMapping("/log/getLog")
    String queryStaff(@RequestParam("page") Integer tPage,@RequestParam("rows") Integer tNumber);

    @RequestMapping("/log/insertLog")
    void addInfo(@RequestParam("s") String s);
}
