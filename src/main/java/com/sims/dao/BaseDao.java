package com.sims.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 基础Dao
 */
public class BaseDao {
    static DruidDataSource druidDataSource = null;
    private static void init() throws IOException {
        druidDataSource = new DruidDataSource();
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        assert is != null;//
        // 种加载是加载的 classes 文件下的 resources 会自动到 classes文件下，如果没有及时更新，就跑不起来
        properties.load(is);
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String jdbcPoolInitSize = properties.getProperty("jdbcPoolInitSize");
        druidDataSource.setDriverClassName(properties.getProperty("driver"));
        druidDataSource.setUrl(properties.getProperty("url"));
        druidDataSource.setUsername(properties.getProperty("user"));
        druidDataSource.setPassword(properties.getProperty("password"));
        druidDataSource.setInitialSize(Integer.parseInt(properties.getProperty("jdbcPoolInitSize")));
    }

    //获取connection
    public static Connection getConnection() throws IOException, SQLException {
        if (druidDataSource==null){
            init();//如果没有初始化就初始化
        }
        return  druidDataSource.getConnection();
    }
    @Test  //测试数据池 getConnection()
    public void test(){
        Connection connection = null;
        try {
            connection = getConnection();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM `sims`.`account` LIMIT 0,1000";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("a_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
