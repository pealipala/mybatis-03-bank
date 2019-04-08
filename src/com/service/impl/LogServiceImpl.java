package com.service.impl;

import com.pojo.Log;
import com.pojo.PageInfo;
import com.service.LogService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogServiceImpl  implements LogService{
    @Override
    public PageInfo show(int pageSize, int pageNum) throws IOException {
        //获取PageInfo对象
        PageInfo pageInfo=new PageInfo();
        //获取mybatis.xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        //使用工厂设计模式
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //生成Sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建map
        Map<String,Object> map=new HashMap<>();
        map.put("pageStart",pageSize*(pageNum-1));
        map.put("pageSize", pageSize);
        //返回查询结果
        List<Log> list = sqlSession.selectList("com.mapper.LogMapper.selAll", map);
        long count = sqlSession.selectOne("com.mapper.LogMapper.selCount");
        //给pageInfo传值
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNum(pageNum);
        pageInfo.setList(list);
        pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
        //返回pageInfo对象
        return pageInfo;
    }
}
