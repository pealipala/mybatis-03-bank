package com.service;

import com.pojo.PageInfo;

import java.io.IOException;

public interface LogService {
    /**
     *
     * @author : yechaoze
     * @date : 2019/4/8 12:18
     * @param pageSize : 
     * @param pageNum : 
     * @return : com.pojo.PageInfo
     */
    PageInfo show(int pageSize, int pageNum) throws IOException;
}
