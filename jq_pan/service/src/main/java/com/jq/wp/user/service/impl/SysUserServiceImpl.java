package com.jq.wp.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jq.common.api.exception.model.ServiceException;
import com.jq.common.api.rest.ResponseCode;
import com.jq.common.api.utils.IdUtil;
import com.jq.common.api.utils.PasswordUtil;
import com.jq.wp.user.context.UserRegisterContext;
import com.jq.wp.user.converter.UserConverter;
import com.jq.wp.user.domain.model.SysUser;
import com.jq.wp.user.mapper.SysUserMapper;
import com.jq.wp.user.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author 30627
 * @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
 * @createDate 2024-02-24 17:33:22
 */
@Service(value = "sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Resource
    UserConverter userConverter;

    @Override
    public Long register(UserRegisterContext userRegisterContext) throws ServiceException {
        assembleUserEntity(userRegisterContext);
        doRegister(userRegisterContext);
        createUserRootFolder(userRegisterContext);
        return userRegisterContext.getSysUser().getId();
    }

    private void createUserRootFolder(UserRegisterContext userRegisterContext) {

    }

    /**
     * 实现注册用户的业务
     * 需要捕获数据库的唯一索引冲突异常,来实现全局用户名称唯一
     * @param userRegisterContext
     */

    private void doRegister(UserRegisterContext userRegisterContext) throws ServiceException {
        SysUser sysUser = userRegisterContext.getSysUser();
        if (Objects.nonNull(sysUser)){
            try {
                if (!save(sysUser)){
                    throw new ServiceException("用户注册失败");
                }
            } catch (DuplicateKeyException e) {
                throw new ServiceException("用户名已存在");
            }

        }
        throw new ServiceException(ResponseCode.ERROR.getCode(), "用户上下文为空");
    }

    /**
     * 创建用户的根目录信息
     * @param userRegisterContext
     */

    private void assembleUserEntity(UserRegisterContext userRegisterContext) {
        SysUser sysUser = userConverter.userRegisterContext2SysUser(userRegisterContext);
        String salt = PasswordUtil.getSalt(),
                dbPassword = PasswordUtil.encryptPassword(salt, userRegisterContext.getPassword());
        sysUser.setId(IdUtil.get());
        sysUser.setSalt(salt);
        sysUser.setPassword(dbPassword);
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        userRegisterContext.setSysUser(sysUser);
    }
}




