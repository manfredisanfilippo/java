package com.example.gokart.controller_app;

import com.example.gokart.bean.LoginBean;
import com.example.gokart.dao.UserDao;
import com.example.gokart.entity.User;

import java.sql.SQLException;

public class UserControllerApp {

    public static LoginBean login(LoginBean loginBean) throws Exception, SQLException {
        UserDao userDao = new UserDao();
        User user = userDao.findUser(loginBean.getUsername(), loginBean.getPassword());
        loginBean.setRole(user.getRole());
        loginBean.setUsername(user.getUsername());
        loginBean.setPassword(user.getPassword());
        loginBean.setId(user.getId());
        return loginBean;
    }

    public static Boolean signin(LoginBean loginBean) throws Exception, SQLException {
        UserDao userDao = new UserDao();
        Boolean checkIfCreated = userDao.createUser(loginBean.getUsername(), loginBean.getPassword(), loginBean.getRole());
        if (!checkIfCreated) {
            throw new Exception();
        }
        return true;
    }

    //public void logout(LoginBean loginBean) {
      //  SessionManager.getInstance().removeSession(loginBean.getIdSession());
    //}

}
