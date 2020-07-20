package com.sims.service.account;

import com.sims.dao.BaseDao;
import com.sims.dao.account.AccountDao;
import com.sims.dao.account.AccountDaoImpl;
import com.sims.pojo.Account;
import org.junit.Test;

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

    /**
     * 搜索 account封装 动态SQL
     *
     * @param account
     * @return
     */
    @Override
    public Account search(Account account) {
        Account _account = null;
        Connection connection = null;
        if (account != null) {
            try {
                connection= BaseDao.getConnection();
                _account = accountDao.search(connection,account);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResources(connection,null,null);
            }
        }
        return _account;
    }

    /**
     * 修改
     * 事务
     *
     * @param account
     * @return
     */
    @Override
    public boolean mofify(Account account) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启事务
            flag = accountDao.mofify(connection,account);//修改

            connection.commit();//成就体积哦啊
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            BaseDao.closeResources(connection,null,null);
        }
        return flag;
    }

    /**
     * add 事务
     *
     * @param account
     * @return
     */
    @Override
    public boolean add(Account account) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启事务
            flag = accountDao.add(connection,account);//修改

            connection.commit();//成就体积哦啊
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            BaseDao.closeResources(connection,null,null);
        }
        return flag;
    }

    /**
     * delete
     * 事务
     *
     * @param a_user
     * @return
     */
    @Override
    public boolean delete(String a_user) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            flag = accountDao.delete(connection,a_user);

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            flag = false;
        }

        return flag;
    }
    @Test //测试 delete
    public void test1() throws SQLException, IOException, ClassNotFoundException {
        String user = "412";
        System.out.println(delete( user));
    }
    @Test //测试 添加
    public void test() throws SQLException, IOException, ClassNotFoundException {
        Account account = new Account();
        account.setA_user("45343");
        Account search = search( account);
        search.setA_name("李亚洲");
        search.setA_user("ff哈比");

        System.out.println(search.getA_name());
        boolean mofify = add( search);
        System.out.println(mofify);

    }
}
