package com.sxt;

import java.sql.*;

/**
 * @author fly
 * @date 2019/6/5
 * 测试PreparedStatement
 */
public class Test03 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
            //?占位符
            String sql = "insert into t_user (username,pwd,regTime) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            //参数索引从1开始
            ps.setString(1,"Test03");
            ps.setString(2,"dasda");
            ps.setDate(3,new java.sql.Date(System.currentTimeMillis()));

            ps.setObject(1,"object");
            ps.setObject(2,"ok");
            ps.setObject(3,new java.sql.Date(System.currentTimeMillis()));
            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
