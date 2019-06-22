package com.sxt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author fly
 * @date 2019/6/5
 * 测试执行SQL语句，以及SQL注入问题
 */
public class Test02 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
            Statement stmt = conn.createStatement();
            String sql = "insert into t_user (username,pwd,regtime) values ('idea',6666,now())";
            String id = "5 or 1=1";
            String sql2 = "delete from t_user where id="+id;
            stmt.execute(sql2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
