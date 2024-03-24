package com.jq.admin.controller.manager;

import com.jq.admin.config.MqConst;
import com.jq.admin.config.Person;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Date 2024/3/21 11:31
 */
@RestController
@RequestMapping("/")
public class Test {
    @Resource
    private Person person;
/*    @Resource
    private MqConst mqConst;*/

    @GetMapping("/")
    public String a() {
        return MqConst.hebei1;
    }

}
