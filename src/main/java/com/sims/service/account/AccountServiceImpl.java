package com.sims.service.account;

import com.sims.dao.BaseDao;
import com.sims.dao.account.AccountDao;
import com.sims.dao.account.AccountDaoImpl;
import com.sims.pojo.Account;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    AccountDao accountDao ;

    public AccountServiceImpl() {
        accountDao = new AccountDaoImpl();
    }

    /**
     * 登录 账号密码用 account封装
     *
     * @param account
     * @return
     */
    @Override
    public Account login(Account account) {
        Account _account = null;
        Connection connection = null;
        if (account != null) {
            try {
                 connection= BaseDao.getConnection();
                _account = accountDao.login(connection,account);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResources(connection,null,null);
            }
        }
        return _account;
    }
}
