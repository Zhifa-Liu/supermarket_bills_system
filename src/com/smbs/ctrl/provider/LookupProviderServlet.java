package com.smbs.ctrl.provider;

import com.smbs.dao.ProviderDao;
import com.smbs.entity.Provider;

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
public class LookupProviderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String proName = request.getParameter("providerName");
        String proDesc = request.getParameter("providerDesc");
        //也可通过Mysql like 子句进行模糊匹配
        ProviderDao providerDao = ProviderDao.getSingletonInstance();
        List<Provider> pros = providerDao.selectAll();
        List<Provider> proQuery = new ArrayList<>();
        for(Provider p: pros){
            //或许更为恰当的是使用正则表达式
            if(p.getProviderName().contains(proName)&&p.getDescription().contains(proDesc)){
                proQuery.add(p);
            }
        }
        request.setAttribute("proQuery",proQuery);
        request.getRequestDispatcher("providerLookup.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
