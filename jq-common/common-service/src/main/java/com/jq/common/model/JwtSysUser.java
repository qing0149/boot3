package com.jq.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-02-11 16:09
 **/
@Getter
@AllArgsConstructor
public class JwtSysUser {

    private final UserBean user;

    @JsonIgnore
    private final List<UserPermission> authorities;

}
