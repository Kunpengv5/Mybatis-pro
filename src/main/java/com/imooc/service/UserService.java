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

    /**
     * 获取全部的用户
     * @return
     */
    public List<Users> getAllUsers(){
        return userDAO.getAllUsers();
    }

    /**
     * 根据id获取指定用户
     * @param id
     * @return
     */
    public Users getUserById(Integer id){
        return userDAO.getUserById(id);
    }

    public void addUser(Users users){
        userDAO.addUser(users);
    }


}
