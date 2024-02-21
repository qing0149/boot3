package com.jq.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jq.common.api.rest.Result;
import com.jq.domain.vo.TestVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-02-11 18:10
 **/
@RestController
@RequestMapping("body1")
@Tag(name = "aaa参数")
public class TestController {
    @Operation(summary = "我是表单")
    @ApiOperationSupport(order = 10)
    @GetMapping("/user")
    public Result<String> test() {
        return Result.success();
    }

    @Operation(summary = "我是表单1")
    @ApiOperationSupport(order = 10)
    @GetMapping("/user1")
    public Result<String> test1(@Validated TestVO vo) {
        return Result.success(vo.toString());
    }
}
