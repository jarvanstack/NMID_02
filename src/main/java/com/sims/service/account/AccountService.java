package com.sims.service.account;

import com.sims.pojo.Account;


public interface AccountService {
    /**
     * 登录 账号密码用 account封装
     * @param account
     * @return
     */
    Account login(Account account);

}
