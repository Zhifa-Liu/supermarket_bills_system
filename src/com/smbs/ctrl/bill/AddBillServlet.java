package com.smbs.ctrl.bill;

import com.smbs.dao.BillDao;
import com.smbs.entity.Bill;
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
public class AddBillServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String billId = request.getParameter("billId");
        String productName = request.getParameter("productName");
        String productDesc = request.getParameter("productDesc");
        int productCount = Integer.parseInt(request.getParameter("productCount"));
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        int isPay = Integer.parseInt(request.getParameter("isPay"));
        int providerId = Integer.parseInt(request.getParameter("provider"));
        String creator = ((User)request.getSession().getAttribute("user")).getUserId();
        Date createTime = new Date();
        Bill b = new Bill(billId,productName,productDesc,productCount,totalPrice,isPay,providerId,creator,createTime);

        BillDao billDao = BillDao.getSingletonInstance();
        billDao.insert(b);

        response.sendRedirect("ListBillsServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
