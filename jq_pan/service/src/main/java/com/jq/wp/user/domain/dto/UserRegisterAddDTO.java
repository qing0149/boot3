package com.jq.wp.user.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-02-25 13:09
 **/
@Schema(description = "用户注册DTO")
@Data
public class UserRegisterAddDTO implements Serializable {
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

    @Schema(description = "答案")
    @NotBlank
    private String answer;

}
