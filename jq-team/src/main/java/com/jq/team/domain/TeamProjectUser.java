package com.jq.team.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 项目参与人表
 * @TableName team_project_user
 */
@TableName(value ="team_project_user")
@Data
public class TeamProjectUser implements Serializable {
    /**
     * 主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目主键Id
     */
    @TableField(value = "project_id")
    private String projectId;

    /**
     * 用户Id:sys_user.id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 是否是主负责人:0否1是
     */
    @TableField(value = "principal_flag")
    private Integer principalFlag;

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