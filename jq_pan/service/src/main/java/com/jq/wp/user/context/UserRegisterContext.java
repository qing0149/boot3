package com.jq.wp.user.context;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @program: Boot3
 * @description:用户注册上下文对象
 * @author:
 * @create: 2024-02-25 15:16
 **/
@Data
public class UserRegisterContext implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户姓名")
    @NotBlank
    private String userName;

    @Schema(description = "账号")
    @NotBlank
    private String password;

    @Schema(description = "问题")
    @NotBlank
    private String question;

    @Schema(description = "密保答案")
    @NotBlank
    private String answer;
}
