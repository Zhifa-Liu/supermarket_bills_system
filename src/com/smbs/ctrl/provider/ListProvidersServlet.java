package com.smbs.ctrl.provider;

import com.smbs.dao.ProviderDao;
import com.smbs.entity.Provider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 32098
 */
public class ListProvidersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProviderDao providerDao = ProviderDao.getSingletonInstance();
        List<Provider> providers = providerDao.selectAll();
        request.setAttribute("providers",providers);
        request.getRequestDispatcher("providerAdmin.jsp").forward(request, response);
    }
}