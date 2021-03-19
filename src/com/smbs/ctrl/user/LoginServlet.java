package com.smbs.ctrl.user;

import com.smbs.dao.UserDao;
import com.smbs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author 32098
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String userId = request.getParameter("userId");
        String password = request.getParameter("passWord");

        HttpSession session = request.getSession();

        User u = UserDao.getSingletonInstance().selectById(userId);
        if(u!=null && u.getPassword().equals(password)){
            session.setAttribute("user",u);
            response.sendRedirect("admin_index.html");
        }else{
            response.sendRedirect("login.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
