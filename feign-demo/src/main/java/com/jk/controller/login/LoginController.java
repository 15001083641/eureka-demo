package com.jk.controller.login;

import com.alibaba.fastjson.JSON;
import com.jk.model.login.LogBean;
import com.jk.pool.ThreadPool;
import com.jk.service.login.LogThread;
import com.jk.service.login.LoginService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping(value = "login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 向消息队列新增消息队列内容
     * @param phoneNumber
     * @return
     */
    @RequestMapping(value = "sendSms")
    @ResponseBody
    public Boolean sendSms(String phoneNumber){
        HashMap<String, Object> map = new HashMap<>();
        map.put("phonenumber","15001083641");
        map.put("content",new Random().nextInt(100));
        amqpTemplate.convertAndSend(JSON.toJSONString(map));
        return true;
    }

    /**
     * 登陆
     * @param loginNumber
     * @param password
     * @return
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public Boolean login(String loginNumber,String password){
        LogBean logBean = new LogBean();
        logBean.setIp("127.0.0.1");
        logBean.setIpAddress("中国");
        logBean.setLog("日志记录"+ UUID.randomUUID().toString());
        logBean.setLogTime(new Date());
        logBean.setName("insertLog");
        logBean.setRequestMsg("loginNumber="+loginNumber+"password="+password);
        logBean.setResponseMsg("{'loginNumber':'admin','password':'admin'}");
        ThreadPool.executor(new LogThread(loginService,logBean));
        return true;
    }
}
