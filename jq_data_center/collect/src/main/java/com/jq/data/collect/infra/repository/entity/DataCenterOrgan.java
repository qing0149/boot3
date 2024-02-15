package com.jq.data.collect.infra.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 组织结构
 * @TableName t_data_center_organ
 */
@TableName(value ="t_data_center_organ")
@Data
public class DataCenterOrgan implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 规则表主键id
     */
    private Long ruleId;

    /**
     * 抽取组织方式 1：sql抽取 2：接口抽取
     */
    private Integer collectWay;

    /**
     * collec_way抽取组织方式 1：sql抽取  sql脚本 2：接口抽取 url http地址
     */
    private String content;

    /**
     * 抽取组织的数据源
     */
    private String dataSource;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 状态 1未删除 0删除
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}