package com.jq.data.collect.business.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

@Data
public class Storage implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public static final String DEFAULT_TABLE_PREFIX = "t_generate_";
    public static final String DEFAULT_DATASOURCE = "jq_dev";
    public static final String DEFAULT_TABLE_SUFFIX = "day";
    public static final String DEFAULT_NOT_DAY_SUFFIX = "statistics";

    private Long id;

    private Long rule;

    private String dataSource;

    private String tablePrefix;

    public String getTablePrefix() {
        return Optional.ofNullable(tablePrefix).orElse(DEFAULT_TABLE_PREFIX);
    }

    public static Storage defaultStorage() {
        Storage storage = new Storage();
        storage.setTablePrefix(DEFAULT_TABLE_PREFIX);
        storage.setDataSource(DEFAULT_DATASOURCE);
        return storage;
    }

}