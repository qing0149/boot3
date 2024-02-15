package com.jq.data.collect.infra.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 数据采集
 * @TableName t_data_center_metadata
 */
@TableName(value ="t_data_center_metadata")
@Data
public class DataCenterMetadata implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 规则表主键id
     */
    private Long ruleId;

    /**
     * 指标英文标识
     */
    private String enName;

    /**
     * 指标中文标识
     */
    private String cnName;

    /**
     * 指标默认是否展示
     */
    private Boolean defaultShow;

    /**
     * 是否存储当前指标
     */
    private Boolean storage;

    /**
     * 当前指标是否和维度有关
     */
    private Boolean dimension;

    /**
     * 当前指标是否和统计周期有关
     */
    private Boolean period;

    /**
     * 指标数据类型
     */
    private String dataType;

    /**
     * 指标类型：1抽取类型 2计算类型
     */
    private Integer sourceType;

    /**
     * 生命周期规则id
     */
    private Integer lifeCycleRuleId;

    /**
     * 跟踪的UUID
     */
    private String traceId;

    /**
     * 数据安全信息字段id
     */
    private Integer dataSecurity;

    /**
     * 前端展示宽度
     */
    private Integer extraWidth;

    /**
     * 指标描述
     */
    private String description;

    /**
     * 指标排序
     */
    private Integer rank;

    /**
     * 基准值，用来做展示数据
     */
    private Integer baseValue;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 状态：1未删除 0删除
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}