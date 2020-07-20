package com.sims.dao.account;

import com.sims.dao.BaseDao;
import com.sims.pojo.Account;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class AccountDaoImpl implements AccountDao {
    /**
     * 登录 账号密码用 account封装
     *
     * @param connection
     * @param account
     * @return
     */
    @Override
    public Account login(Connection connection, Account account) {
        Account _account = new Account();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            ArrayList<Object> params = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            String baseSql = "SELECT\n" +
                    "\tsims.account.*, \n" +
                    "\tsims.major.m_name\n" +
                    "FROM\n" +
                    "\tsims.account,\n" +
                    "\tsims.major\n" +
                    "WHERE\n" +
                    "\taccount.a_user = ? AND\n" +
                    "\taccount.a_password = ? AND\n" +
                    "\taccount.a_major_id = major.m_major_id";
            params.add(account.getA_user());
            params.add(account.getA_password());
            sql.append(baseSql);
            try {
                preparedStatement = connection.prepareStatement(sql.toString());
                resultSet = BaseDao.executeQuery(preparedStatement,params.toArray());
                while (resultSet.next()) {
                    _account.setA_id(resultSet.getInt("a_id"));
                    _account.setA_name(resultSet.getString("a_name"));
                    _account.setA_gender(resultSet.getInt("a_gender"));
                    _account.setA_birthday(resultSet.getDate("a_birthday"));
                    _account.setA_user(resultSet.getString("a_user"));
                    _account.setA_password(resultSet.getString("a_password"));
                    _account.setA_major_id(resultSet.getInt("a_major_id"));
                    _account.setA_create_user(resultSet.getString("a_create_user"));
                    _account.setA_create_date(resultSet.getDate("a_create_date"));
                    _account.setA_modify_user(resultSet.getString("a_modify_user"));
                    _account.setA_modfify_date(resultSet.getDate("a_modfify_date")); // 11
                    _account.setAge(new Date().getYear() - resultSet.getDate("a_birthday").getYear());
                    _account.setMajor_name(resultSet.getString("m_name"));//13
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                BaseDao.closeResources(connection,preparedStatement,resultSet);
            }
        }
        return _account;
    }
    @Test //测试登录dao
    public void test(){
        Account account = new Account();
        account.setA_user("1234567");
        account.setA_password("1234567");

        Account login = null;
        try {
            login = login(BaseDao.getConnection(), account);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(login.getMajor_name());

    }
}
