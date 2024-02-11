package com.jq.common.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-02-06 11:30
 **/
@Data
public class UserBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private RoleSmallDTO role;

    private List<RoleSmallDTO> roles;

/*    public List<Long> getRoleIds(){
        List<Long> roleIds = new ArrayList<>();
        this.roles.forEach(item ->{
            roleIds.add(item.getId());
        });
        return roleIds;
    }*/

//    @ApiModelProperty(value = "登录ID")
    private Long loginId;

//    @ApiModelProperty(value = "昵称")
    private String nickName;

//    @ApiModelProperty(value = "姓名")
    private String fullName;

//    @ApiModelProperty(value = "密码")
    private String password;

//    @ApiModelProperty(value = "手机号码")
    private String phone;

//    @ApiModelProperty(value = "是否会员")
    private Boolean flagMember;

//    @ApiModelProperty(value = "头像地址")
    private String avatarName;

//    @ApiModelProperty(value = "身份:1-客户;2-平台管理;3-商户")
    private Integer identity;

//    @ApiModelProperty(value = "后台帐号状态:0->禁用；1->启用")
    private Integer status;

//    @ApiModelProperty(value = "后台帐号状态:0->禁用；1->启用")
    private Boolean enabled;

//    @ApiModelProperty(value = "角色ID")
    private Long roleId;

//    @ApiModelProperty(value = "客户状态状态:0->禁用；1->启用")
    private Integer customerStatus;

//    @ApiModelProperty(value = "性别:0-未知;1-男;2-女")
    private Integer gender;

//    @ApiModelProperty(value = "生日")
    private Date birthday;

//    @ApiModelProperty(value = "城市ID")
    private Long cityId;

//    @ApiModelProperty(value = "城市名称")
    private String cityName;

//    @ApiModelProperty(value = "供应商id")
    private Long supplierId;

//    @ApiModelProperty(value = "总积分/福币")
    private BigDecimal totalPoints;

//    @ApiModelProperty(value = "使用过的总积分/福币")
    private BigDecimal useTotalPoints;

    /**
     * 微信openid
     */
//    @ApiModelProperty(value = "微信openid",example = "efewf33333", position = 81)
    private String openId;
    /**
     * 微信unionid
     */
//    @ApiModelProperty(value = "微信unionid",example = "efewf33333", position = 91)
    private String unionId;

    /**
     * 登录令牌
     */
//    @ApiModelProperty(value = "登录令牌",example = "1221333331", position = 111)
    private String token;

}
