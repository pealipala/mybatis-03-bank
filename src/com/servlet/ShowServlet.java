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
    //获取service层对象
    private LogService logService=new LogServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageSize=2;
        int pageNum=1;
        //获取请求信息
        String pageSizestr=req.getParameter("pageSize");
        String pageNumstr=req.getParameter("pageNum");
        //处理请求信息
        if(pageSizestr!=null&&!pageSizestr.equals("")){
            pageSize= Integer.parseInt(pageSizestr);
        }
        if(pageNumstr!=null&&!pageNumstr.equals("")){
            pageNum= Integer.parseInt(pageNumstr);
        }
        PageInfo pageInfo = logService.show(pageSize,pageNum);
        //返回请求结果
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("/log.jsp").forward(req,resp);
    }
}
