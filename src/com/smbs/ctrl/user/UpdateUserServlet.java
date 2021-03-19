package com.smbs.ctrl.user;

import com.smbs.dao.UserDao;
import com.smbs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author 32098
 */
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userId = request.getParameter("userId");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String pswRepeat = request.getParameter("password1");
        String gender = request.getParameter("sex");
        String d = request.getParameter("birthday");
        System.out.println(d);
        Date birthday = new Date(d.replace('-','/'));
        System.out.println(birthday);
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");

        String tip="";
        int role = Integer.parseInt(request.getParameter("auth"));
        if (userId==null || username==null || password==null) {
            tip = "存在必填项为空";
        }else{
            if (password.equals(pswRepeat)) {
                User u = new User(userId,username,password,mobile,address,gender,birthday,role);
                UserDao.getSingletonInstance().update(u);
            }else{
                tip = "两次密码不一致";
                request.setAttribute("tip",tip);
            }
        }
        response.sendRedirect("ListUsersServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
