package com.jq.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserPermission implements Serializable {

    /**
     *Comment for <code>serialVersionUID</code>
     */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 权限字符串
     */
//    @ApiModelProperty(value = "权限字符串",example = "sys.role.add",position = 1)
    private String permission;

//    @Override
//    public String getAuthority() {
//        return this.permission;
//    }

}
