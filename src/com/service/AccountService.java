package com.service;

import com.pojo.Account;

import java.io.IOException;

public interface AccountService {
    /**
     * @param accIn  :
     * @param accOut :
     * @return : int
     * @author : yechaoze
     * @date : 2019/4/7 16:44
     */
    int transfer(Account accIn, Account accOut) throws IOException;

    /**
     * 账号和密码不匹配状态码
     */
    int ACCOUNT_PASSWORD_NOT_MATCH = 1;
    /**
     * 余额不足状态码
     */
    int ACCOUNT_BANLANCE_NOT_ENOUGH = 2;
    /**
     * 账户姓名不匹配
     */
    int ACCOUNT_NAME_NOT_MATCH = 3;
    /**
     * 转账失败
     */
    int ERROR = 4;
    /**
     * 转账成功
     */
    int SUCCESS=5;
}
