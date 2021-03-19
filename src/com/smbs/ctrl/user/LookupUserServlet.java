package com.smbs.ctrl.user;

import com.smbs.dao.UserDao;
import com.smbs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 32098
 */
public class LookupUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        UserDao userDao = UserDao.getSingletonInstance();
        List<User> users = userDao.selectAll();
        List<User> userQuery = new ArrayList<>();
        for(User u:users){
            if(u.getUserName().contains(userName)){
                userQuery.add(u);
            }
        }
        request.setAttribute("userQuery",userQuery);
        request.getRequestDispatcher("userLookup.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
