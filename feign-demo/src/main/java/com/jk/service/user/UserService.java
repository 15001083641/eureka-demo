package com.jk.service.user;

import com.jk.model.freemaker.Ma;
import com.jk.model.freemaker.UserBean;

import java.util.List;

public interface UserService {

    List<UserBean>  queryUser();

    Ma queryUserId(Integer userId);

    void insertMa(Ma ma);

    /*UserInfo findByUsername(String username);*/
}
