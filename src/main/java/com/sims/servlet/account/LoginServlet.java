package com.sims.servlet.account;

import com.sims.pojo.Account;
import com.sims.service.account.AccountService;
import com.sims.service.account.AccountServiceImpl;
import com.sims.util.Constants01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean flag = false;
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account _account = null;
        Account account = new Account();
        account.setA_user(username);
        account.setA_password(password);
        _account = accountService.login(account);

        if (_account != null) {
            //查询成功account不为空
            flag = true;
        }

        if (flag) {
            //如果查询成功 设置session + 转发到 index.jsp
            req.getSession().setAttribute(Constants01.USER_SERSSION,_account);
            resp.sendRedirect("jsp/index.jsp");
        }else{
            //如果 登录失败 转发会原页面 + error
            req.setAttribute("error","账号或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
