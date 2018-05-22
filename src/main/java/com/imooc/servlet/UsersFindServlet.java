package com.imooc.servlet;

import com.imooc.dao.UserDAO;
import com.imooc.entity.Users;
import com.imooc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author dukunpeng
 * @date 2018/5/18 16:25
 */
@WebServlet("/index")
public class UsersFindServlet extends HttpServlet {

    //创建userService对象
    private  UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService = new UserService();
        //通过getAllUsers方法获取到所有的用户
        List<Users> list = userService.getAllUsers();
//        System.out.println(list);
        //将用户的list信息，传递给前台页面
        req.setAttribute("usersList", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
