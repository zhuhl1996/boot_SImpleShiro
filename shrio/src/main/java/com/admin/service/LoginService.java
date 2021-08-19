package com.admin.service;

import com.admin.dao.LoginDao;
import com.admin.pojo.UserCommen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhl on 2021/8/18.
 */
@Service
public class LoginService implements LoginDao {
    @Autowired
    LoginDao loginDao;

    @Override
    public UserCommen getUserByName(String name) {
        return loginDao.getUserByName(name);
    }
}
