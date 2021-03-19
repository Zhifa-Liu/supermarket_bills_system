package com.smbs.ctrl.user;

import com.smbs.dao.UserDao;
import com.smbs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 32098
 */
public class ListUsersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = UserDao.getSingletonInstance();
        List<User> users = userDao.selectAll();
        request.setAttribute("users",users);
        request.getRequestDispatcher("userAdmin.jsp").forward(request, response);
    }
}
