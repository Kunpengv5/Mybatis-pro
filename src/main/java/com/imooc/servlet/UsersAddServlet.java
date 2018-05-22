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
import java.util.Date;

/**
 * @author dukunpeng
 * @date 2018/5/22 16:46
 */
@WebServlet("/addusers")
public class UsersAddServlet extends HttpServlet {

    private UserService userService;
    private Users users;



    Logger logger = Logger.getLogger(UsersAddServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//传值编码
        resp.setContentType("text/html;charset=UTF-8");//设置传输编码

        userService = new UserService();

        logger.info("1.............获取前端页面的参数值");
        String username = req.getParameter("username");
        String userpass = req.getParameter("userpass");
        String nickname = req.getParameter("nickname");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        logger.info(gender);
        logger.info("2.............创建Users对象");
        users = new Users(username,userpass,nickname,Integer.parseInt(age),gender,phone,email, new Date(),new Date(),new Date(),0);
        logger.info("3.............插入数据库Users表");
        userService.addUser(users);
        logger.info("4.............跳转到新增用户详情页面");

        //此处id可以直接getId方式获取，因为mybatis insert时，会调用set和get方法，对users对象进行属性更新
        resp.sendRedirect("/detail?id="+users.getId());

    }
}
