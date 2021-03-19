package com.smbs.ctrl.provider;

import com.smbs.dao.ProviderDao;
import com.smbs.entity.Provider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 32098
 */
public class PreUpdateProServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String proId = request.getParameter("proId");
        ProviderDao providerDao = ProviderDao.getSingletonInstance();
        Provider p = providerDao.selectById(proId);
        request.setAttribute("provider",p);
        request.getRequestDispatcher("providerUpdate.jsp").forward(request, response);
    }
}
