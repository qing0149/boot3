package com.jq.data.collect.infra.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 元数据结构
 * @TableName t_data_center_collect
 */
@TableName(value ="t_data_center_collect")
@Data
public class DataCenterCollect implements Serializable {
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
     * 采集的数据源
     */
    private String dataSource;

    /**
     * 采集方式 1：sql方式采集 2：接口方式采集
     */
    private Integer collectWay;

    /**
     *  取决于collect_way配置，1：sql方式采集, 表示sql脚本 2：接口方式采集，url
     */
    private String content;

    /**
     * 是否去重
     */
    private Boolean deduplicate;

    /**
     * 统计周期格式
     */
    private String periodFormat;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 状态 1未删除 0 删除
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}