package com.sims.dao.account;

import com.sims.dao.BaseDao;
import com.sims.pojo.Account;
import com.sims.util.StringUtil01;
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
            } finally {
                BaseDao.closeResources(connection, preparedStatement, resultSet);
            }
        }
        return _account;
    }

    /**
     * 搜索 account封装 动态SQL
     *
     * @param connection
     * @param account
     * @return
     */
    @Override
    public Account search(Connection connection, Account account) {
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
                    "\t account.a_major_id = major.m_major_id ";
            sql.append(baseSql);
            //动态SQL
            if (StringUtil01.isNotNull(account.getA_name())) {
                sql.append(" and account.a_name = ? ");
                params.add(account.getA_name());
            }
            if (StringUtil01.isNotNull(account.getA_user())) {
                sql.append(" and account.a_user = ? ");
                params.add(account.getA_user());
            }



            try {
                preparedStatement = connection.prepareStatement(sql.toString());
                resultSet = BaseDao.executeQuery(preparedStatement, params.toArray());
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
            } finally {
                BaseDao.closeResources(connection, preparedStatement, resultSet);
            }
        }
        return _account;
    }

    /**
     * 搜索 account封装 动态SQL
     *
     * @param connection
     * @param account
     * @return
     */
    @Override
    public boolean mofify(Connection connection, Account account) {
        boolean flag = false;
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            ArrayList<Object> params = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            String baseSql = "UPDATE `sims`.`account` \n" +
                    "SET `a_name` = ?,\n" +
                    "`a_gender` = ?,\n" +
                    "`a_birthday` = ?,\n" +
                    "`a_user` = ?,\n" +
                    "`a_password` = ?,\n" +
                    "`a_major_id` = ?,\n" +
                    "`a_create_user` = ?,\n" +
                    "`a_create_date` = ?,\n" +
                    "`a_modify_user` = ?,\n" +
                    "`a_modfify_date` = ? ,\n" +
                    "`age` = ? "+//11
                    "WHERE\n" +
                    "\t`a_id` = ?"; //12 id
            sql.append(baseSql);


            params.add(account.getA_name());
            params.add(account.getA_gender());
            params.add(account.getA_birthday());
            params.add(account.getA_user());
            params.add(account.getA_password());
            params.add(account.getA_major_id());
            params.add(account.getA_create_user());
            params.add(account.getA_create_date());
            params.add(account.getA_modify_user());
            params.add(account.getA_modfify_date());
            params.add(account.getUserlessAge()); // 11 不加id

            params.add(account.getA_id());// 12 id



            try {
                System.out.println(baseSql);
                preparedStatement = connection.prepareStatement(baseSql);
                int i = BaseDao.executeUpdate(preparedStatement, params.toArray());
                if (i > 0) {
                    flag = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResources(connection, preparedStatement, null);
            }
        }
        return flag;
    }

    /**
     * add
     *
     * @param connection
     * @param account
     * @return
     */
    @Override
    public boolean add(Connection connection, Account account) {
        boolean flag = false;
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            ArrayList<Object> params = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            String baseSql = "INSERT INTO `sims`.`account` ( `a_name`, `a_gender`, `a_birthday`, `a_user`, `a_password`, `a_major_id`, `a_create_user`, `a_create_date`, `a_modify_user`, `a_modfify_date`, `age` )\n" +
                    "VALUES\n" +
                    "\t( \n" +
                    "\t\t ?,\n" +
                    "\t\t?,\n" +
                    "\t\t?,\n" +
                    "\t\t?,\n" +
                    "\t\t?,\n" +
                    "\t\t?,\n" +
                    "\t\t?,\n" +
                    "\t\t?,\n" +
                    "\t\t?,\n" +
                    "\t?,\n" +
                    "\t?)"; //11 不加 id
            sql.append(baseSql);


            params.add(account.getA_name());
            params.add(account.getA_gender());
            params.add(account.getA_birthday());
            params.add(account.getA_user());
            params.add(account.getA_password());
            params.add(account.getA_major_id());
            params.add(account.getA_create_user());
            params.add(account.getA_create_date());
            params.add(account.getA_modify_user());
            params.add(account.getA_modfify_date());
            params.add(account.getUserlessAge()); // 11 不加id




            try {
                System.out.println(baseSql);
                preparedStatement = connection.prepareStatement(sql.toString());
                int i = BaseDao.executeUpdate(preparedStatement, params.toArray());
                if (i > 0) {
                    flag = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResources(connection, preparedStatement, null);
            }
        }
        return flag;
    }

    /**
     * delete
     *
     * @param connection
     * @param a_user
     * @return
     */
    @Override
    public boolean delete(Connection connection, String a_user) throws SQLException {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        String baseSql = "DELETE FROM `sims`.`account` WHERE `a_user` = ?";
        ArrayList<Object> params = new ArrayList<>();
        params.add(a_user);

        preparedStatement = connection.prepareStatement(baseSql);
        int i = BaseDao.executeUpdate(preparedStatement, params.toArray());
        if (i > 0) {
            flag = true;
        }
        BaseDao.closeResources(connection,preparedStatement,null);
        return flag;
    }

    @Test //测试 delete
    public void test() throws SQLException, IOException, ClassNotFoundException {
        String user = "哈比";
        System.out.println(delete(BaseDao.getConnection(), user));
    }
}
