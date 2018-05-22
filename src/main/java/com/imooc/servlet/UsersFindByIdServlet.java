package com.imooc.servlet;

import com.imooc.entity.Users;
import com.imooc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 通过用户id查询到用户信息，传递给前台页面
 * @author dukunpeng
 * @date 2018/5/21 11:20
 */
@WebServlet("/detail")
public class UsersFindByIdServlet extends HttpServlet {
    UserService userService;
    Users user;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      super.doPost(req, resp);
        userService = new UserService();
        //前台获取到id信息
        String id = req.getParameter("id");
        user = userService.getUserById(Integer.valueOf(id));
        req.setAttribute("user",user);
        req.getRequestDispatcher("detail.jsp").forward(req,resp);
    }
}
