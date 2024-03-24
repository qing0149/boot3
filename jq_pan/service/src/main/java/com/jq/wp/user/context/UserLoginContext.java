package com.jq.wp.user.context;

import com.jq.wp.user.domain.model.SysUser;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @program: Boot3
 * @description:用户登录业务上下文实体
 * @author:
 * @create: 2024-03-04 22:02
 **/
@Data
public class UserLoginContext implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户姓名")
    private String username;

    @Schema(description = "账号")
    private String password;

    private SysUser sysUser;
    /**
     * 登录成功之后的登录凭证信息
     */
    private String accessToken;

}
