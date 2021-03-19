package com.smbs.ctrl.user;

import com.smbs.dao.UserDao;
import com.smbs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 32098
 */
public class PreUpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userId = request.getParameter("userId");
        UserDao userDao = UserDao.getSingletonInstance();
        User user = userDao.selectById(userId);
        request.setAttribute("user",user);
        request.getRequestDispatcher("userUpdate.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
