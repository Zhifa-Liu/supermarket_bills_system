package com.smbs.ctrl.bill;

import com.smbs.dao.BillDao;
import com.smbs.entity.Bill;

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
public class LookupBillServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String productName = request.getParameter("productName");
        int isPay = Integer.parseInt(request.getParameter("payStatus"));
        //也可通过Mysql like 子句进行模糊匹配
        BillDao billDao = BillDao.getSingletonInstance();
        List<Bill> bills = billDao.selectAll();
        List<Bill> billQuery = new ArrayList<>();
        for(Bill b:bills){
            //或许更为恰当的是使用正则表达式
            if(b.getProductName().contains(productName)&&b.isPayment()==isPay){
                billQuery.add(b);
            }
        }
        request.setAttribute("billQuery",billQuery);
        request.getRequestDispatcher("billLookup.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
