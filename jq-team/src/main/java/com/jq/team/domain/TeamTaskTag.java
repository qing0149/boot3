package com.jq.team.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 项目标签和任务的关系表
 * @TableName team_task_tag
 */
@TableName(value ="team_task_tag")
@Data
public class TeamTaskTag implements Serializable {
    /**
     * 关系表主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 任务模块表Id:team_task.id
     */
    @TableField(value = "task_id")
    private Long taskId;

    /**
     * 用户Id:sys_user.id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 执行人标识:0否1是
     */
    @TableField(value = "execute_flag")
    private Integer executeFlag;

    /**
     * 参与者标识
     */
    @TableField(value = "participant_flag")
    private Integer participantFlag;

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