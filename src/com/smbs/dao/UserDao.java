package com.smbs.dao;

import com.smbs.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 32098
 */
public class UserDao extends BaseDao<User>{

    private static UserDao userDao = null;

    private UserDao(){}

    public static synchronized UserDao getSingletonInstance(){
        if (userDao == null){
            userDao = new UserDao();
        }
        return userDao;
    }

    @Override
    public User selectById(String id) {
        try {
            User u = null;
            Connection con = this.openConnection();
            String sql = "select * from superusers where userid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                String userId = rs.getString("userid");
                String userName = rs.getString("username");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                Date birthday = rs.getDate("ubirthday");
                int role = rs.getInt("role");
                u = new User(userId, userName, password, phone, address, gender, birthday, role);
            }
            return u;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> selectAll() {
        try {
            List<User> users = new ArrayList<>();
            Connection con = this.openConnection();
            String sql = "select * from superusers";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String userId = rs.getString("userid");
                String userName = rs.getString("username");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                Date birthday = rs.getDate("ubirthday");
                int role = rs.getInt("role");
                User u = new User(userId, userName, password, phone, address, gender, birthday, role);
                users.add(u);
            }
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(User user) {
        try {
            Connection con = this.openConnection();
            String sql = "insert into superusers values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUserId());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getPassword());
            ps.setString(4,user.getPhone());
            ps.setString(5, user.getAddress());
            ps.setString(6,user.getGender());
            ps.setDate(7,new java.sql.Date(user.getBirthday().getTime()));
            ps.setInt(8,user.getRole());
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
            String sql = "delete from superusers where userid=?";
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
    public void update(User user) {
        try {
            Connection con = this.openConnection();
            String sql = "update superusers set username=?,password=?,phone=?,address=?,gender=?,ubirthday=?,role=? where userid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getPhone());
            ps.setString(4,user.getAddress());
            ps.setString(5,user.getGender());
            ps.setDate(6,new java.sql.Date(user.getBirthday().getTime()));
            ps.setInt(7,user.getRole());
            ps.setString(8,user.getUserId());
            ps.executeUpdate();
            ps.close();
            this.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
