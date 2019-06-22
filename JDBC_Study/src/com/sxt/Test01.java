package com.sxt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author fly
 * @date 2019/6/5
 * 测试数据库连接
 */
public class Test01 {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            long t0 = System.currentTimeMillis();
            //建立连接（连接对象内部其实包含了Sockect对象，是一个远程的连接，比较耗时！这是Connection对象管理的一个要点！）
            //真正开发中，为了提高效率，都会使用连接池来管理连接对象！
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
            long t1 = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println(t1-t0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
