package com.jq.data.collect.infra.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 数据存储
 * @TableName t_data_center_storage
 */
@TableName(value ="t_data_center_storage")
@Data
public class DataCenterStorage implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 规则表主键id
     */
    private Long rule;

    /**
     * 存储当前规则下的指标所用的数据源，默认是data-center
     */
    private String dataSource;

    /**
     * 自动生成表前缀，默认为t_generate_，生成表的规则：t_generate_{en_name}_{dimension}_{date}
     */
    private String tablePrefix;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 状态 1未删除 0 删除
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}