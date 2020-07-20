package com.sims.service.account;

import com.sims.pojo.Account;

import java.sql.Connection;
import java.sql.SQLException;


public interface AccountService {
    /**
     * 登录 账号密码用 account封装
     * @param account
     * @return
     */
    Account login(Account account);

    /**
     * 搜索 account封装 动态SQL
     *
     * @param account
     * @return
     */
    Account search( Account account);

    /**
     * 修改
     * 事务
     * @param account
     * @return
     */
    boolean mofify(Account account);

    /**
     * add 事务
     * @param account
     * @return
     */
    boolean add( Account account);


    /**
     * delete
     * 事务
     * @param a_user
     * @return
     */
    boolean delete( String  a_user);
}
