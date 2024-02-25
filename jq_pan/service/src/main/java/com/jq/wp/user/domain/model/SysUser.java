package com.jq.wp.user.domain.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户信息表
 * @TableName sys_user
 */
@TableName(value ="sys_user")
@Data
public class SysUser {

    /**
     * 用户id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Long roleId;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 性别:0:女 1:男: 2:其他
     */
    @TableField(value = "gender")
    private String gender;

    /**
     * 手机号码
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private Date birthday;

    /**
     * 微信小程序openId
     */
    @TableField(value = "wx_open_id")
    private String wxOpenId;

    /**
     * 微信公众号openId
     */
    @TableField(value = "wx_mp_open_id")
    private String wxMpOpenId;

    /**
     * 总积分
     */
    @TableField(value = "total_points")
    private BigDecimal totalPoints;

    /**
     * 获得过的总积分
     */
    @TableField(value = "total_points_obtained")
    private BigDecimal totalPointsObtained;

    /**
     * 租户ID
     */
    @TableField(value = "tenant_id")
    private Long tenantId;

    /**
     * 随机盐值
     */
    @TableField(value = "salt")
    private String salt;

    /**
     * 密保问题
     */
    @TableField(value = "question")
    private String question;

    /**
     * 密保答案
     */
    @TableField(value = "answer")
    private String answer;

    /**
     * 状态:0禁用,1启用
     */
    @TableField(value = "enabled")
    private Long enabled;

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
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 修改人
     */
    @TableField(value = "update_by")
    private Long updateBy;
}