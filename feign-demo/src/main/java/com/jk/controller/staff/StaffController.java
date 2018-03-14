package com.jk.controller.staff;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.model.login.LogBean;
import com.jk.model.staff.StaffBean;
import com.jk.pool.ThreadPool;
import com.jk.service.staff.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.management.Query;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    //查询员工信息
    @RequestMapping(value = "queryStaff")
    @ResponseBody
    public String queryStaff(Integer tPage,Integer tNumber){
        String s = staffService.queryStaff(tPage, tNumber);
        return s;
    }

    //新增
    @RequestMapping(value = "addInfo")
    @ResponseBody
    public void addInfo(LogBean logBean){
        String s = JSON.toJSONString(logBean);
        staffService.addInfo(s);
    }


}
