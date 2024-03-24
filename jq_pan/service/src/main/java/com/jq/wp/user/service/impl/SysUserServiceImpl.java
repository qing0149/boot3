package com.jq.wp.user.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jq.cache.constants.CacheConstants;
import com.jq.common.api.exception.model.ServiceException;
import com.jq.common.api.rest.ResponseCode;
import com.jq.common.api.utils.IdUtil;
import com.jq.common.api.utils.JwtUtil;
import com.jq.common.api.utils.PasswordUtil;
import com.jq.common.api.utils.UUIDUtil;
import com.jq.wp.file.constants.FileConstants;
import com.jq.wp.file.context.CreateFolderContext;
import com.jq.wp.file.service.PanUserFileService;
import com.jq.wp.user.constants.UserConstants;
import com.jq.wp.user.context.UserLoginContext;
import com.jq.wp.user.context.UserRegisterContext;
import com.jq.wp.user.converter.UserConverter;
import com.jq.wp.user.domain.model.SysUser;
import com.jq.wp.user.mapper.SysUserMapper;
import com.jq.wp.user.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private UserConverter userConverter;
    @Resource
    private PanUserFileService userFileService;
    @Resource
    private CacheManager cacheManager;
    @Resource
    private JwtUtil jwtUtil;

    @Override
    @Transactional
    public Long register(UserRegisterContext userRegisterContext) throws ServiceException {
        assembleUserEntity(userRegisterContext);
        doRegister(userRegisterContext);
        createUserRootFolder(userRegisterContext);
        return userRegisterContext.getSysUser().getId();
    }

    /**
     * 登录业务实现
     * 1.用户登录西悉尼校验
     * 2.生成一个具有实效性的accessToken
     * 3.将accessToken缓存起来,区实现单机登录
     *
     * @param ctx
     * @return
     */
    @Override
    public String login(UserLoginContext ctx) throws ServiceException {
        checkLoginInfo(ctx);
        generateAnd(ctx);
        return ctx.getAccessToken();
    }

    /**
     * 用户推出登录
     * 1.清楚用户的登录凭证缓存
     *
     * @param userId
     */
    @Override
    public void exit(Long userId) throws ServiceException {
        try {
            //todo 这两个方法干啥的不知道
            Cache cache = cacheManager.getCache(CacheConstants.R_PAN_CACHE_NAME);
            cache.evict(UserConstants.USER_LOGIN_PREFIX + userId);
        } catch (Exception e) {
            throw new ServiceException("用户退出登录失败");
        }
    }


    /**
     * --------------私有方法-------------------------
     **/
    private void generateAnd(UserLoginContext ctx) {
        SysUser sysUser = ctx.getSysUser();
        String accessToken = JwtUtil.generateToken(sysUser.getUsername(), UserConstants.LOGIN_USER_ID, sysUser.getId(), UserConstants.ONE_DAY_LONG);
//        String accessToken = JwtUtil.generateToken(sysUser.getUsername(), UserConstants.ONE_DAY_LONG);
//        String accessToken = UUIDUtil.getUUID();
        Cache cache = cacheManager.getCache(CacheConstants.R_PAN_CACHE_NAME);
        assert cache != null;
        cache.put(UserConstants.USER_LOGIN_PREFIX + sysUser.getId(), accessToken);
        ctx.setAccessToken(accessToken);

    }

    /**
     * 校验用户名和密码
     *
     * @param ctx
     */
    private void checkLoginInfo(UserLoginContext ctx) throws ServiceException {
        String username = ctx.getUsername();
        String password = ctx.getPassword();
        SysUser sysUser = getSysUserName(username);
        if (ObjectUtil.isNull(username)) {
            throw new ServiceException("用户名不存在");
        }
        String salt = sysUser.getSalt();
        String dpPassword = PasswordUtil.encryptPassword(salt, password);
        if (!ObjectUtil.equal(sysUser.getPassword(), dpPassword)) {
            throw new ServiceException("账号密码错误");
        }
        ctx.setSysUser(sysUser);
    }

    /**
     * 通过用户名称获取实际信息
     *
     * @param username
     * @return
     */

    private SysUser getSysUserName(String username) {
        LambdaQueryWrapper<SysUser> qw = new LambdaQueryWrapper<>();
        qw.eq(SysUser::getUsername, username);
        return this.getOne(qw);
    }


    private void createUserRootFolder(UserRegisterContext userRegisterContext) throws ServiceException {
        CreateFolderContext createFolderContext = new CreateFolderContext();
        createFolderContext.setParentId(FileConstants.TOP_PARENT_ID);
        createFolderContext.setUserId(userRegisterContext.getSysUser().getId());
        createFolderContext.setFolderName(FileConstants.ALL_FILE_CN_STR);
        userFileService.createFolder(createFolderContext);
    }

    /**
     * 实现注册用户的业务
     * 需要捕获数据库的唯一索引冲突异常,来实现全局用户名称唯一
     *
     * @param userRegisterContext
     */
    private void doRegister(UserRegisterContext userRegisterContext) throws ServiceException {
        SysUser sysUser = userRegisterContext.getSysUser();
        if (Objects.nonNull(sysUser)) {
            try {
                if (!save(sysUser)) {
                    throw new ServiceException("用户注册失败");
                }
            } catch (DuplicateKeyException e) {
                throw new ServiceException("用户名已存在");
            }

        } else {
            throw new ServiceException(ResponseCode.ERROR.getCode(), "用户上下文为空");
        }
    }

    /**
     * 创建用户的根目录信息
     *
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




