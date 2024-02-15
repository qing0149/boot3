package com.jq.data.collect.infra.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 数据规则
 * @TableName t_data_center_rule
 */
@TableName(value ="t_data_center_rule")
@Data
public class DataCenterRule implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 业务id，兼容不同系统生成id的规则可能是不一样的
     */
    private String businessId;

    /**
     * 业务名称
     */
    private String businessName;

    /**
     * 业务英文标识
     */
    private String enName;

    /**
     * 当前规则名称
     */
    private String ruleName;

    /**
     * 规则类型，兼容采集规则、查询规则
     */
    private String ruleType;

    /**
     * 版本好，如果需要规则变更，直接创建一个新规则，将版本号递增
     */
    private String version;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 1未删除 0删除
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}