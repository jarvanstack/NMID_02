package com.sims.servlet.account;

import com.sims.pojo.Account;
import com.sims.service.account.AccountService;
import com.sims.service.account.AccountServiceImpl;
import com.sims.util.Constants01;
import com.sims.util.StringUtil01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

///jsp/account.do
public class AccountServlet extends HttpServlet {
    AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method != null) {
            if (method.equals("search")) {
                //执行查询功能
                search(req, resp);
            } else if (method.equals("modify")) {
                modify(req, resp);
            } else if (method.equals("add")) {
                add(req, resp);
            }else if (method.equals("delete")){
                //
                delete(req,resp);
            }
        } else {
            //错误
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //查询
    private void search(HttpServletRequest req, HttpServletResponse resp) {
        boolean flag = false;
        String a_name = req.getParameter("a_name");
        String a_user = req.getParameter("a_user");//学号就是 登录名称
        Account account = new Account();

        if (StringUtil01.isNotNull(a_name)) {
            account.setA_name(a_name);
        }
        if (StringUtil01.isNotNull(a_user)) {
            account.setA_user(a_user);//使用account封装参数
        }
        Account _account = null;


        _account = accountService.search(account); // 查询操作


        if (_account != null) {
            flag = true;
        }

        if (flag) {
            //如果查询成功
            req.setAttribute("account", account);
            try {
                req.getRequestDispatcher("").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //如果查询失败
            req.setAttribute("error", "查询失败");
            try {
                req.getRequestDispatcher("").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private void modify(HttpServletRequest req, HttpServletResponse resp) {
        boolean flag = false;
        String a_user = req.getParameter("stdNumber");
        String a_name = req.getParameter("name");
        String a_gender = req.getParameter("gender");
        String age = req.getParameter("age");
        String major_id = req.getParameter("major_id");
        Account account = new Account();
        account.setA_user(a_user);//设置user登录名，通过登录名获取Account，在Account的基础上修改
        //
        Account _account = accountService.login(account);
        //major = accountService.getMajorByMajorId(major_id);//设置的时候不用，获取就可以了。
        _account.setA_name(a_name);
        _account.setUserlessAge(Integer.parseInt(age));//无用age
        _account.setA_gender(Integer.parseInt(a_gender));
        _account.setA_major_id(Integer.parseInt(major_id));//
        Object o = req.getSession().getAttribute(Constants01.USER_SERSSION);
        if (o != null) {
            Account modifyAccount = (Account) o;
            _account.setA_modify_user(modifyAccount.getA_user());//
            _account.setA_modfify_date(new Date(System.currentTimeMillis()));// 7 加上id
        }

        flag = accountService.mofify(_account);//修改


        if (flag) {
            //如果修改modify成功
            req.setAttribute("modify", "修改成功");
            try {
                req.getRequestDispatcher("").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //如果modify失败
            req.setAttribute("modify", "查询失败");
            try {
                req.getRequestDispatcher("").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    private void add(HttpServletRequest req, HttpServletResponse resp) {
        boolean flag = false;
        String a_name = req.getParameter("name");
        String a_gender = req.getParameter("gender");
        String uselessAge = req.getParameter("age");
        String a_user = req.getParameter("stdNumber");
        String major_id = req.getParameter("major");//5.
        Account _account = new Account();
        _account.setA_name(a_name);
        _account.setA_gender(Integer.parseInt(a_gender));
        _account.setUserlessAge(Integer.parseInt(uselessAge));
        _account.setA_user(a_user);
        _account.setA_major_id(Integer.parseInt(major_id));

        Object o = req.getSession().getAttribute(Constants01.USER_SERSSION);
        if (o != null) {
            Account createrAccount = (Account) o;
            _account.setA_create_user(createrAccount.getA_user());
            _account.setA_create_date(new Date(System.currentTimeMillis()));//7
        }
        flag = accountService.add(_account); //执行添加操作

        if (flag) {

            //如果修改add成功
            req.setAttribute("add", "添加成功");
            try {
                req.getRequestDispatcher("").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //如果add失败
            req.setAttribute("add", "添加失败");
            try {
                req.getRequestDispatcher("").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 其实可以不用正的删除，给给几个删除的字段就可以了。
     * idDelete  delete_by delete_date
     * @param req
     * @param resp
     */
    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        boolean flag = false;
        String a_user = req.getParameter("stdNumber");//删除的学号


        flag = accountService.delete(a_user); //删除



        if (flag) {

            //如果delete成功
            req.setAttribute("delete", "delete成功");
            try {
                req.getRequestDispatcher("").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //如果delete失败
            req.setAttribute("delete", "delete失败");
            try {
                req.getRequestDispatcher("").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }













}
