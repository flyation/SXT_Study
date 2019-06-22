package com.sxt;

import java.sql.*;
import java.util.Random;

/**
 * @author fly
 * @date 2019/6/5
 * 随机时间
 */
public class Test07 {
    public static void main(String[] args) throws InterruptedException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");

            for (int i=0;i<1000;i++){
                int rd = new Random().nextInt(1000*60*60*24*7);
                String sql = "insert into t_user (username,regTime) values (?,?)";
                ps = conn.prepareStatement(sql);
                ps.setObject(1,"Fly"+i);
                ps.setObject(2,new Timestamp(System.currentTimeMillis()-rd));
                ps.execute();
                System.out.println("插入用户");
            }

            System.out.println("结束");

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
