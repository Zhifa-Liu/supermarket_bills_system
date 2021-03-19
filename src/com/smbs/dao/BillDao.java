package com.smbs.dao;

import com.smbs.entity.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 32098
 */
public class BillDao extends BaseDao<Bill>{
    private static BillDao billDao = null;

    private BillDao(){}

    public static synchronized BillDao getSingletonInstance(){
        if (billDao == null){
            billDao = new BillDao();
        }
        return billDao;
    }

    @Override
    public Bill selectById(String id) {
        try {
            Bill b = null;
            Connection con = this.openConnection();
            String sql = "select * from superbills where billid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                String billId = rs.getString("billid");
                String productName = rs.getString("productname");
                String productDesc = rs.getString("productdesc");
                int productCount = rs.getInt("productcount");
                double totalPrice = rs.getDouble("totalprice");
                int isPayment = rs.getInt("ispayment");
                int providerId = rs.getInt("providerid");
                String creator = rs.getString("creator");
                Date createTime = rs.getDate("createTime");
                b = new Bill(billId,productName,productDesc,productCount,totalPrice,isPayment,providerId,creator,createTime);
            }
            return b;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Bill> selectAll() {
        try {
            List<Bill> bills = new ArrayList<>();
            Connection con = this.openConnection();
            String sql = "select * from superbills";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String billId = rs.getString("billid");
                String productName = rs.getString("productname");
                String productDesc = rs.getString("productdesc");
                int productCount = rs.getInt("productcount");
                double totalPrice = rs.getDouble("totalprice");
                int isPayment = rs.getInt("ispayment");
                int providerId = rs.getInt("providerid");
                String creator = rs.getString("creator");
                Date createTime = rs.getDate("createTime");
                Bill b = new Bill(billId,productName,productDesc,productCount,totalPrice,isPayment,providerId,creator,createTime);
                bills.add(b);
            }
            return bills;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Bill bill) {
        try {
            Connection con = this.openConnection();
            String sql = "insert into superbills values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,null);
            ps.setString(2,bill.getProductName());
            ps.setString(3,bill.getProductDesc());
            ps.setInt(4,bill.getProductCount());
            ps.setDouble(5,bill.getTotalPrice());
            ps.setInt(6,bill.isPayment());
            ps.setInt(7,bill.getProviderId());
            ps.setString(8,bill.getCreator());
            ps.setDate(9, new java.sql.Date(bill.getCreateTime().getTime()));
            ps.executeUpdate();
            ps.close();
            this.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try{
            Connection con = this.openConnection();
            String sql = "delete from superbills where billid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ps.executeUpdate();
            ps.close();
            this.closeConnection(con);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Bill bill) {
        try {
            Connection con = this.openConnection();
            String sql = "update superbills set productname=?,productdesc=?,productcount=?,totalprice=?,ispayment=?,providerid=?,creator=?,createtime=? where billid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,bill.getProductName());
            ps.setString(2,bill.getProductDesc());
            ps.setInt(3,bill.getProductCount());
            ps.setDouble(4,bill.getTotalPrice());
            ps.setInt(5,bill.isPayment());
            ps.setInt(6,bill.getProviderId());
            ps.setString(7,bill.getCreator());
            ps.setDate(8, new java.sql.Date(bill.getCreateTime().getTime()));
            ps.setString(9,bill.getBillId());
            ps.executeUpdate();
            ps.close();
            this.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
