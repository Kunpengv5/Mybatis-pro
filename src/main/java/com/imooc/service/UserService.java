package com.imooc.service;

import com.imooc.dao.UserDAO;
import com.imooc.entity.Users;

import java.util.List;

/**
 * @author dukunpeng
 * @date 2018/5/18 16:09
 */
public class UserService {
    private UserDAO userDAO = new UserDAO();
    public List<Users> getAllUsers(){
        return userDAO.getAllUsers();
    }

    public Users getUserById(Integer id){
        return userDAO.getUserById(id);
    }
}
