package com.jq.wp.user.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

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
    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = "^[0-9A-Za-z]{6,16}$", message = "请输入6-16位只包含数字和字符的用户名")
    private String username;

    @Schema(description = "密码")
    @NotBlank
    @Length(min = 8, max = 16, message = "请输入8-1位的密码")
    private String password;

    @Schema(description = "问题")
    @NotBlank
    @Length(max = 100, message = "密保问题不能超过100个字符")
    private String question;

    @Schema(description = "答案")
    @NotBlank
    @Length(max = 100, message = "密保答案不能超过100个字符")
    private String answer;

}
