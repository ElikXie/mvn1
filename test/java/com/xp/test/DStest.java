package com.xp.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledCallableStatement;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DStest {
    public void DStest01() throws Exception {
        ComboPooledDataSource ds1 = new ComboPooledDataSource();
        ds1.setDriverClass("com.mysql.jdbc.Driver");
        ds1.setJdbcUrl("jdbc:mysql://159.75.139.145:3306");
        ds1.setUser("forjdbc");
        ds1.setPassword("123456");
        Connection conn1 = ds1.getConnection();

    }
    public void DStest02() throws Exception {
        DruidDataSource ds2 = new DruidDataSource();

        ds2.setDriverClassName("com.mysql.jdbc.Driver");
        ds2.setUrl("jdbc:mysql://159.75.139.145:3306");
        ds2.setUsername("forjdbc");
        ds2.setPassword("123456");
        DruidPooledConnection conn2 = ds2.getConnection();

    }
    @Test
    public void test03() throws SQLException {
        ResourceBundle br = ResourceBundle.getBundle("jdbc");
        String driver = br.getString("jdbc.driver");
        String url = br.getString("jdbc.url");
        String username = br.getString("jdbc.username");
        String password = br.getString("jdbc.password");
        System.out.println(driver+url+username+password);
        DruidDataSource ds1 = new DruidDataSource();
        ds1.setDriverClassName(driver);
        ds1.setUrl(url);
        ds1.setUsername(username);
        ds1.setPassword(password);
        DruidPooledConnection conn1 = ds1.getConnection();
        System.out.println(conn1);
        String sql = "insert into jdbc.jduser values(30,'tian',20)";
        String sql2 ="commit";
        PreparedStatement ps1 = conn1.prepareStatement(sql);
        PreparedStatement ps2 = conn1.prepareStatement(sql2);
        ds1.close();

    }
}
