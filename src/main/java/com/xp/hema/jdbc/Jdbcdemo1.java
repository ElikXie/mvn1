package com.xp.hema.jdbc;

import java.sql.*;

public class Jdbcdemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://159.75.139.145:3306","forjdbc","123456");
            Statement sta1 = conn.createStatement();
            String sql1 = "delete from jdbc.jduser where id > 5";
            int a = sta1.executeUpdate(sql1);
            String sql2 = "commit";
            boolean b = sta1.execute(sql2);
            sta1.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

        }


    }
}
