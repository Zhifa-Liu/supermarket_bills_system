package com.smbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 32098
 */
public abstract class BaseDao<Type> {
    protected static final String CLASS_NAME="com.mysql.cj.jdbc.Driver";
    protected static final String URL="jdbc:mysql://localhost:3306/smbs?useUnicode=true&characterEncoding=UTF-8&" +
            "zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&" +
            "useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
    protected static final String USERNAME="root";
    protected static final String PASSWORD="root";

    public Connection openConnection() {
        Connection con = null;
        try {
            Class.forName(CLASS_NAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeConnection(Connection con) {
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract Type selectById(String id);

    public abstract List<Type> selectAll();

    public abstract void insert(Type type);

    public abstract void delete(String id);

    public abstract void update(Type type);
}
