package com.jq.wp.user.controller;


import com.jq.common.api.exception.model.ServiceException;
import com.jq.common.api.rest.Result;
import com.jq.wp.common.utils.UserIdUtils;
import com.jq.wp.user.context.UserLoginContext;
import com.jq.wp.user.context.UserRegisterContext;
import com.jq.wp.user.converter.UserConverter;
import com.jq.wp.user.domain.dto.UserLoginDTO;
import com.jq.wp.user.domain.dto.UserRegisterAddDTO;
import com.jq.wp.user.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:该类是用户模块的控制器实体
 * @author:
 * @create: 2024-02-25 00:11
 **/
@RestController
@RequestMapping("/user")
@Tag(name = "用户模块")
public class UserController {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private UserConverter userConverter;

    @PostMapping("register")
    @Operation(description = "用户注册")
    public Result<String> register(@Validated @RequestBody UserRegisterAddDTO dto) throws ServiceException {
        UserRegisterContext userRegisterContext = userConverter.userRegisterPO2UserRegisterContext(dto);
        Long id = sysUserService.register(userRegisterContext);
        return Result.success("注册成功");
    }

    @PostMapping("login")
    @Operation(description = "用户登录接口")
    public Result login(@Validated @RequestBody UserLoginDTO dto) throws ServiceException {
        UserLoginContext ctx = userConverter.UserLoginDTO2UserLoginContext(dto);
        String accessToken = sysUserService.login(ctx);
        //todo 需要修改
        return Result.success(accessToken);
    }

    @PostMapping("exit")
    @Operation(description = "用户登出功能")
    public Result exit() throws ServiceException {
        sysUserService.exit(UserIdUtils.get());
        return Result.success("登录成功");
    }
}
