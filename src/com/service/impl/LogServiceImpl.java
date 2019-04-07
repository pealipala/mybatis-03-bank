package com.service.impl;

import com.pojo.Log;
import com.pojo.PageInfo;
import com.service.LogService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.security.krb5.internal.PAData;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogServiceImpl  implements LogService{
    @Override
    public PageInfo show(int pageSize, int pageNum) throws IOException {
        PageInfo pageInfo=new PageInfo();
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String,Object> map=new HashMap<>();
        map.put("pageStart",pageSize*(pageNum-1));
        map.put("pageSize", pageSize);
        List<Log> list = sqlSession.selectList("com.mapper.LogMapper.selAll", map);
        long count = sqlSession.selectOne("com.mapper.LogMapper.selCount");

        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNum(pageNum);
        pageInfo.setList(list);
        pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);

        return pageInfo;
    }
}
