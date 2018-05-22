package com.imooc.servlet;

import com.imooc.entity.Users;
import com.imooc.service.UserService;
import org.apache.log4j.Logger;

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
    private UserService userService;
    private Users user;
    private Logger log = Logger.getLogger(UsersFindByIdServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService = new UserService();
        String id = req.getParameter("id");

        log.info("获取到前台的查询参数id--->"+id);

        user = userService.getUserById(Integer.valueOf(id));

        log.info("查询完成，查询到的数据:"+ user);

        req.setAttribute("user",user);
        req.getRequestDispatcher("detail.jsp").forward(req,resp);
    }
}
