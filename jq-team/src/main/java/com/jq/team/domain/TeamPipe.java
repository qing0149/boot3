package com.jq.team.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 项目通道表
 * @TableName team_pipe
 */
@TableName(value ="team_pipe")
@Data
public class TeamPipe implements Serializable {
    /**
     * 项目管道主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目创建表:team_project.id
     */
    @TableField(value = "project_id")
    private Long projectId;

    /**
     * 管道名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 通道状态:0未开始:1进行中:2:已结束:3:二次处理4:已关闭
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 管道排序
     */
    @TableField(value = "sort")
    private Integer sort;

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