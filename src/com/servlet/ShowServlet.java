package com.servlet;

import com.pojo.PageInfo;
import com.service.LogService;
import com.service.impl.LogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowServlet",urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    private LogService logService=new LogServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageSize=2;
        int pageNum=1;
        String pageSizestr=req.getParameter("pageSize");
        if(pageSizestr!=null&&!pageSizestr.equals("")){
            pageSize= Integer.parseInt(pageSizestr);
        }
        String pageNumstr=req.getParameter("pageNum");
        if(pageNumstr!=null&&!pageNumstr.equals("")){
            pageNum= Integer.parseInt(pageNumstr);
        }
        PageInfo pageInfo = logService.show(pageSize,pageNum);
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("/log.jsp").forward(req,resp);
    }
}
