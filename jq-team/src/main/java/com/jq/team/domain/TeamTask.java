package com.jq.team.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 任务模块表
 * @TableName team_task
 */
@TableName(value ="team_task")
@Data
public class TeamTask implements Serializable {
    /**
     * 任务模块表主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 需求来源
     */
    @TableField(value = "demand_source")
    private String demandSource;

    /**
     * 问题描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 详细描述
     */
    @TableField(value = "detail_description")
    private String detailDescription;

    /**
     * 截至时间
     */
    @TableField(value = "deadline")
    private Date deadline;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    private Long createBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 更新人
     */
    @TableField(value = "update_by")
    private Long updateBy;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}