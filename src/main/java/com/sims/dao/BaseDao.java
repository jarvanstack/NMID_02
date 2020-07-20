package com.sims.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 基础Dao
 */
public class BaseDao {
    //获取connection
    public static Connection getConnection(){
        Connection connection = null;
        DruidDataSource druidDataSource = new DruidDataSource();
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        druidDataSource.setDriverClassName(properties.getProperty("driver"));
        druidDataSource.setUrl(properties.getProperty("url"));
        druidDataSource.setUsername(properties.getProperty("user"));
        druidDataSource.setInitialSize(Integer.parseInt(properties.getProperty("jdbcPoolInitSize")));//初始化个数
        try {
            connection = druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            //异常
        }

        return  connection;
    }
    @Test  //测试数据池 getConnection()
    public void test(){
        Connection connection = getConnection();

    }
}
