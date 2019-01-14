package com.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface BasMapper<T> extends Mapper<T>, MySqlMapper<T> {
    // TODO
    // FIXME 特别注意，该接口不能被MapperScan扫描到，否则会出错！
    // 开始理解错了，以为是不能被spring容器扫描到，其实是不能被MapperScan扫描到
}
