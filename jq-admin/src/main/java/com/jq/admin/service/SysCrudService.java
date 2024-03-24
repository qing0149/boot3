package com.jq.admin.service;


import com.jq.common.api.rest.Result;

/**
 * 数据库操作工具服务
 * @author bingo
 * @date 2023-03-14
 */
public interface SysCrudService {

    /**
     * 分页查询
     * @param sql 查询语句
     * @return
     */
//    Result queryPageList(String sql, BaseRequest baseRequest);

    /**
     * 插入
     * @param sql 执行语句
     * @return
     */
    Boolean cmdInsetData(String sql);

    /**
     * 更新
     * @param sql 执行语句
     * @return
     */
    Boolean cmdUpdateData(String sql);

    /**
     * 删除
     * @param sql 执行语句
     * @return
     */
    Boolean cmdDeleteData(String sql);

    Result<Object> queryPageList(String crud);
}
