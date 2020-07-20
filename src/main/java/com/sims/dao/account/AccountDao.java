package com.sims.dao.account;

import com.sims.pojo.Account;

import java.sql.Connection;
import java.sql.SQLException;

public interface AccountDao {
    /**
     * 登录 账号密码用 account封装
     *
     * @param connection
     * @param account
     * @return
     */
    Account login(Connection connection, Account account);

    /**
     * 搜索 account封装 动态SQL
     *
     * @param connection
     * @param account
     * @return
     */
    Account search(Connection connection, Account account);

    /**
     * 修改
     *
     * @param connection
     * @param account
     * @return
     */
    boolean mofify(Connection connection, Account account);

    /**
     * add
     *
     * @param connection
     * @param account
     * @return
     */
    boolean add(Connection connection, Account account);

    /**
     * delete
     *
     * @param connection
     * @param a_user
     * @return
     */
    boolean delete(Connection connection, String  a_user) throws SQLException;
}
