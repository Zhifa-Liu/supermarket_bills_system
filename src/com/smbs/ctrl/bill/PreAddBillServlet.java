package com.smbs.ctrl.bill;

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
public class PreAddBillServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProviderDao providerDao = ProviderDao.getSingletonInstance();
        List<Provider> providers = providerDao.selectAll();
        request.setAttribute("providers",providers);
        request.getRequestDispatcher("billAdd.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
