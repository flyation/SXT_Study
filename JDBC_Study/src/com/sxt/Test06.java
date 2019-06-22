package com.sxt;

import java.sql.*;

/**
 * @author fly
 * @date 2019/6/5
 * 测试事务 ACID
 */
public class Test06 {
    public static void main(String[] args) throws InterruptedException {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");

            conn.setAutoCommit(false);

            String sql = "insert into t_user (username,regTime) values (?,?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,"Test06OK");
            ps.setObject(2,new java.sql.Timestamp(System.currentTimeMillis()));
            ps.execute();
            System.out.println("插入第一个用户");


            Thread.sleep(3000);

            ps2 = conn.prepareStatement(sql);
            ps2.setObject(1,"Test06Fail");
            ps2.setObject(2,new java.sql.Date(System.currentTimeMillis()));
            ps2.execute();
            System.out.println("插入第二个用户");

            conn.commit();

            System.out.println("全部成功！");

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
