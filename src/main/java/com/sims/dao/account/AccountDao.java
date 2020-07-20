package com.sims.dao.account;

import com.sims.pojo.Account;

import java.sql.Connection;

public interface AccountDao {
    /**
     * 登录 账号密码用 account封装
     * @param connection
     * @param account
     * @return
     */
    Account login(Connection connection,Account account);
}
