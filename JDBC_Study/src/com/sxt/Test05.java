package com.sxt;

import java.sql.*;

/**
 * @author fly
 * @date 2019/6/5
 * 测试批处理Batch
 */
public class Test05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
            //设为手动提交
            conn.setAutoCommit(false);
            long t0 = System.currentTimeMillis();
            stmt = conn.createStatement();
            for (int i=0;i<20000;i++){
                stmt.addBatch("insert into t_user (username,pwd,regTime) values ('fly"+i+"',1998,now())");
            }
            stmt.executeBatch();
            conn.commit();
            long t1 = System.currentTimeMillis();
            System.out.println("耗时："+(t1-t0));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //遵循后开先
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt!=null){
                try {
                    stmt.close();
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
