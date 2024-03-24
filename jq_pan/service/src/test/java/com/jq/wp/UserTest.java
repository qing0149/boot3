package com.jq.wp;

import com.jq.wp.user.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-04 00:58
 **/
@SpringBootTest(classes = WPApplication.class)
public class UserTest {
    @Autowired
    private SysUserService sysUserService;
    @Test
    public void testRegUser(){
//        sysUserService.register();
    }
}
