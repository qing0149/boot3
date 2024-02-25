package com.jq.wp.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jq.common.api.exception.model.ServiceException;
import com.jq.wp.user.context.UserRegisterContext;
import com.jq.wp.user.domain.model.SysUser;


/**
* @author 30627
* @description 针对表【sys_user(用户信息表)】的数据库操作Service
* @createDate 2024-02-24 17:33:22
*/

public interface SysUserService extends IService<SysUser> {

    Long register(UserRegisterContext userRegisterContext) throws ServiceException;

}
