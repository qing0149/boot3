package com.jq.data.collect.infra.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 数据计算
 * @TableName t_data_center_calculate
 */
@TableName(value ="t_data_center_calculate")
@Data
public class DataCenterCalculate implements Serializable {
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
     * 指标计算时的参数，可以指定多个en_name，用英文逗号分隔
     */
    private String parameters;

    /**
     * 指标计算函数，内置几个 1：sum 累加 2：deduction 相减 3.multiply 相乘 4：ratio 相除 5: avg 平均数
     */
    private String func;

    /**
     * 指标计算表达式
     */
    private String expression;

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