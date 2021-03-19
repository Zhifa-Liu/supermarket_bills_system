package com.smbs.ctrl.bill;

import com.smbs.dao.BillDao;
import com.smbs.dao.ProviderDao;
import com.smbs.entity.Bill;
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
public class ListBillsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillDao billDao = BillDao.getSingletonInstance();
        List<Bill> bills = billDao.selectAll();
        request.setAttribute("bills",bills);
        ProviderDao providerDao = ProviderDao.getSingletonInstance();
        List<Provider> providers = providerDao.selectAll();
        request.setAttribute("providers",providers);
        request.getRequestDispatcher("billAdmin.jsp").forward(request,response);
    }
}
