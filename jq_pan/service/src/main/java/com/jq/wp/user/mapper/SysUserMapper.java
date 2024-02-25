package com.jq.wp.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jq.wp.user.domain.model.SysUser;


/**
* @author 30627
* @description 针对表【sys_user(用户信息表)】的数据库操作Mapper
* @createDate 2024-02-24 17:33:22
* @Entity generator.domain.SysUser
*/
//@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    String selectCountName();
}




