package com.jk.service.login;

import com.alibaba.fastjson.JSON;
import com.jk.model.login.LogBean;

public class LogThread implements Runnable {

    private LoginService loginService;
    private LogBean logBean;

    @Override
    public void run() {
        String s = JSON.toJSONString(logBean);
        loginService.saveLog(s);
    }

    public LogThread() {
    }

    public LogThread(LoginService loginService, LogBean logBean) {
        this.loginService = loginService;
        this.logBean = logBean;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public LogBean getLogBean() {
        return logBean;
    }

    public void setLogBean(LogBean logBean) {
        this.logBean = logBean;
    }
}
