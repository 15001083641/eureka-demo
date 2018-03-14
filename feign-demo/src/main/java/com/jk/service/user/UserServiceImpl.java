package com.jk.service.user;

import com.jk.mapper.user.UserMapper;
import com.jk.model.freemaker.Ma;
import com.jk.model.freemaker.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List queryUser() {
        return userMapper.queryUser();
    }

    @Override
    public Ma queryUserId(Integer userId) {
        return userMapper.queryUserId(userId);
    }

    @Override
    public void insertMa(Ma ma) {
        userMapper.insertMa(ma);
    }

    /*@Override
    public UserInfo findByUsername(String username) {
        return userMapper.findByUsername(username);
    }*/
}
