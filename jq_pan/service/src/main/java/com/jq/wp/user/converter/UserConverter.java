package com.jq.wp.user.converter;

import com.jq.wp.user.context.UserRegisterContext;
import com.jq.wp.user.domain.dto.UserRegisterAddDTO;
import com.jq.wp.user.domain.model.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @program: Boot3
 * @description:用户实体转换工具类
 * @author:
 * @create: 2024-02-25 15:19
 **/
@Mapper(componentModel = "spring")
public interface UserConverter {
    /**
     * 将UserRegisterAddDTO转换成UserRegisterContext
     * @param dto
     * @return
     */
    UserRegisterContext userRegisterPO2UserRegisterContext(UserRegisterAddDTO dto);

    @Mapping(target = "password",ignore = true)
    SysUser userRegisterContext2SysUser(UserRegisterContext userRegisterContext);

}
