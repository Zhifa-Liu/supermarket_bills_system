package com.smbs.ctrl.provider;

import com.smbs.dao.ProviderDao;
import com.smbs.entity.Provider;
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
public class AddProviderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String proId = request.getParameter("proId");
        String proName = request.getParameter("proName");
        String proDesc = request.getParameter("proDesc");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String creator = ((User) request.getSession().getAttribute("user")).getUserId();
        Date createTime = new Date();

        Provider p = new Provider(proId, proName, proDesc, phone, address, creator, createTime);
        ProviderDao providerDao = ProviderDao.getSingletonInstance();
        providerDao.insert(p);

        response.sendRedirect("ListProvidersServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
