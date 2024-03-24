package com.jq.team.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 项目标签表
 * @TableName team_tag
 */
@TableName(value ="team_tag")
@Data
public class TeamTag implements Serializable {
    /**
     * 标签主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目Id
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 标签名字
     */
    @TableField(value = "name")
    private String name;

    /**
     * 标签颜色
     */
    @TableField(value = "color")
    private String color;

    /**
     * 通用标识:0否1是
     */
    @TableField(value = "common_flag")
    private Integer commonFlag;

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