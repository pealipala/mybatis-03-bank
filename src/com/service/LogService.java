package com.service;

import com.pojo.PageInfo;

import java.io.IOException;

public interface LogService {
    PageInfo show(int pageSize, int pageNum) throws IOException;
}
