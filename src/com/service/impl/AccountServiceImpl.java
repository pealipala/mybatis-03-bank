package com.service.impl;

import com.pojo.Account;
import com.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class AccountServiceImpl implements AccountService {
    @Override
    public int transfer(Account accIn, Account accOut) throws IOException {
        //获取mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        //使用工厂设计模式
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //生产 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Account accOutSel = sqlSession.selectOne("com.mapper.AccountMapper.selByAccnoPwd",accOut);
        if(accOutSel!=null){
            if (accOutSel.getBalance()>=accOut.getBalance()){
                Account accInSel=sqlSession.selectOne("com.mapper.AccountMapper.selByAccnoName",accIn);
                if (accInSel!=null){
                    accIn.setBalance(accOut.getBalance());
                    accOut.setBalance(-accOut.getBalance());
                    int index = sqlSession.update("com.mapper.AccountMapper.updateBalByAccno",accOut);
                    index+=sqlSession.update("com.mapper.AccountMapper.updateBalByAccno",accIn);
                    if(index==2){
                        sqlSession.commit();
                        sqlSession.close();
                        //转账成功
                         return SUCCESS;
                    }else {
                        sqlSession.rollback();
                        //转账失败
                        return  ERROR;
                    }
                }else {
                    //账户姓名不匹配
                    return ACCOUNT_NAME_NOT_MATCH;
                }
            }else{
                //账户余额不足
                return ACCOUNT_BANLANCE_NOT_ENOUGH;
            }
        }else {
            //账号密码不匹配
            return ACCOUNT_PASSWORD_NOT_MATCH;
        }
    }
}
