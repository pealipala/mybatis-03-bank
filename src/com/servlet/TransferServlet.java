package com.servlet;

import com.pojo.Account;
import com.service.AccountService;
import com.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "TransferServlet",urlPatterns = "/transfer")
public class TransferServlet extends HttpServlet {
    private AccountService accountService=new AccountServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //获取请求信息
        int accOutAccNo = Integer.parseInt(req.getParameter("accOutAccNo"));
        int accOutPassword = Integer.parseInt(req.getParameter("accOutPassword"));
        Double accOutBalance = Double.valueOf(req.getParameter("accOutBalance"));
        int accInAccNo = Integer.parseInt(req.getParameter("accInAccNo"));
        String accInName = req.getParameter("accInName");
        //处理请求信息
        Account accOut=new Account();
        accOut.setAccNo(accOutAccNo);
        accOut.setPassword(accOutPassword);
        accOut.setBalance(accOutBalance);

        Account accIn=new Account();
        accIn.setAccNo(accInAccNo);
        accIn.setAccName(accInName);
        int index= accountService.transfer(accIn,accOut);
        //响应处理结果
        if(index==AccountService.SUCCESS){
            resp.sendRedirect("/success.jsp");
        }else {
            HttpSession session = req.getSession();
            session.setAttribute("index",index);
            resp.sendRedirect("/error.jsp");
        }
    }
}
