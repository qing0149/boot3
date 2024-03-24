package com.jq.admin.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlRunner;

import com.jq.admin.service.SysCrudService;
import com.jq.common.api.rest.Result;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据库操作工具 服务实现类
 * </p>
 *
 * @author bingo
 * @data 2023-03-23
 */
@Service
public class SysCrudServiceImpl implements SysCrudService {


/*    @Override
    public Result queryPageList(String sql, BaseRequest baseRequest) {
        List<Map<String,Object>> result = SqlRunner.db().selectList(sql);
        return Result.table(result, baseRequest);
    }*/

    @Override
    public Boolean cmdInsetData(String sql) {
        return SqlRunner.db().insert(sql);
    }

    @Override
    public Boolean cmdUpdateData(String sql) {
        return SqlRunner.db().update(sql);
    }

    @Override
    public Boolean cmdDeleteData(String sql) {
        return SqlRunner.db().delete(sql);
    }

    @Override
    public Result<Object> queryPageList(String sql) {
        List<Map<String,Object>> result = SqlRunner.db().selectList(sql);
        return Result.success(result);
    }
}
