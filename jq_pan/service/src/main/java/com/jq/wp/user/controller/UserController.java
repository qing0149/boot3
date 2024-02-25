package com.jq.wp.user.controller;


import com.jq.common.api.exception.model.ServiceException;
import com.jq.common.api.rest.Result;
import com.jq.wp.user.context.UserRegisterContext;
import com.jq.wp.user.converter.UserConverter;
import com.jq.wp.user.domain.dto.UserRegisterAddDTO;
import com.jq.wp.user.mapper.SysUserMapper;
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
    public Result register(@Validated @RequestBody UserRegisterAddDTO dto) throws ServiceException {
        UserRegisterContext userRegisterContext = userConverter.userRegisterPO2UserRegisterContext(dto);
        Long id = sysUserService.register(userRegisterContext);
        return null;
    }
}
