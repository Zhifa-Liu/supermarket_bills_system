package com.smbs.dao;

import com.smbs.entity.Provider;

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
public class ProviderDao extends BaseDao<Provider>{

    private static ProviderDao providerDao = null;

    private ProviderDao(){}

    public static synchronized ProviderDao getSingletonInstance(){
        if (providerDao == null){
            providerDao = new ProviderDao();
        }
        return providerDao;
    }

    @Override
    public Provider selectById(String id) {
        try {
            Provider p = null;
            Connection con = this.openConnection();
            String sql = "select * from superproviders where providerid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                String providerId = rs.getString("providerid");
                String providerName = rs.getString("providername");
                String description = rs.getString("providerdesc");
                String telephone = rs.getString("providertel");
                String address = rs.getString("provideraddress");
                String creator = rs.getString("creator");
                Date createTime = rs.getDate("createTime");
                p = new Provider(providerId, providerName, description, telephone, address, creator, createTime);
            }
            return p;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Provider> selectAll() {
        try {
            List<Provider> providers = new ArrayList<>();
            Connection con = this.openConnection();
            String sql = "select * from superproviders";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String providerId = rs.getString("providerid");
                String providerName = rs.getString("providername");
                String description = rs.getString("providerdesc");
                String telephone = rs.getString("providertel");
                String address = rs.getString("provideraddress");
                String creator = rs.getString("creator");
                Date createTime = rs.getDate("createTime");
                Provider p = new Provider(providerId, providerName, description, telephone, address, creator, createTime);
                providers.add(p);
            }
            return providers;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Provider provider) {
        try {
            Connection con = this.openConnection();
            String sql = "insert into superproviders values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, provider.getProviderId());
            ps.setString(2, provider.getProviderName());
            ps.setString(3, provider.getDescription());
            ps.setString(4, provider.getTelephone());
            ps.setString(5, provider.getAddress());
            ps.setString(6, provider.getCreator());
            ps.setDate(7, new java.sql.Date(provider.getCreateTime().getTime()));
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
            String sql = "delete from superproviders where providerid=?";
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
    public void update(Provider provider) {
        try {
            Connection con = this.openConnection();
            String sql = "update superproviders set providername=?,providerdesc=?,providertel=?,provideraddress=?,creator=?,createtime=? where providerid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,provider.getProviderName());
            ps.setString(2,provider.getDescription());
            ps.setString(3,provider.getTelephone());
            ps.setString(4,provider.getAddress());
            ps.setString(5,provider.getCreator());
            ps.setDate(6, new java.sql.Date(provider.getCreateTime().getTime()));
            ps.setString(7,provider.getProviderId());
            ps.executeUpdate();
            ps.close();
            this.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args){
//        Date date = new Date();
//        Date d = new java.sql.Date(date.getTime());
//        System.out.println(date.getTime());
//        System.out.println(d.getTime());
//    }

}
