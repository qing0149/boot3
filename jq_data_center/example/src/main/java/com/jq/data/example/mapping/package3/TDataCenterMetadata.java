package com.jq.data.example.mapping.package3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author 18870
 * @since 2023-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TDataCenterMetadata implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private LocalDateTime gmtCreate;


}
