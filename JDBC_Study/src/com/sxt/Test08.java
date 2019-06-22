package com.sxt;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fly
 * @date 2019/6/5
 * 查询一段时间
 */
public class Test08 {
    public static long str2Date(String dateStr){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        try {
            return format.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");

            String sql = "select * from t_user where regTime>? and regTime<? order by regTime";
            ps = conn.prepareStatement(sql);

            java.util.Date start = new java.util.Date(str2Date("2019-6-4 9-9-9"));
            java.util.Date end = new java.util.Date(str2Date("2019-6-4 17-17-17"));
            ps.setObject(1,start);
            ps.setObject(2,end);
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println(rs.getInt("id")+"---"+rs.getString("username")
                        +"---"+rs.getTimestamp("regtime"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
