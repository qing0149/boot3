package com.jq.admin.controller.manager;

import com.alibaba.fastjson.JSONObject;

import com.jq.admin.service.SysCrudService;
import com.jq.common.api.rest.Result;
import com.jq.common.controller.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据库操作工具 前端控制器
 * </p>
 *
 * @author bingo
 * @date 2023-03-23
 */
@RestController
@RequestMapping("/sys/crud")
@RequiredArgsConstructor
public class SysCrudController extends BaseController {

    private final SysCrudService sysCrudService;

    @PostMapping("/cmdCrud")
    public Result<Object> cmdCrud(@RequestBody JSONObject obj) {
//        try {
            String crud = obj.getString("sql").trim();
            String[] sqlWords = crud.split(" ");
        return switch (sqlWords[0].toUpperCase()) {
            case "SELECT", "SHOW" ->
//                    return sysCrudService.queryPageList(crud, baseRequest);
                    sysCrudService.queryPageList(crud);
            case "UPDATE" -> {
                Boolean updateStatus = sysCrudService.cmdUpdateData(crud);
                yield Result.success(updateStatus);
            }
            case "CREATE", "ALTER", "INSERT" -> {
                Boolean insertStatus = sysCrudService.cmdInsetData(crud);
                yield Result.success(insertStatus);
            }
            case "DELETE" -> {
                Boolean deleteStatus = sysCrudService.cmdDeleteData(crud);
                yield Result.success(deleteStatus);
            }
            default -> Result.success("输入的语句不合法，请检查后再执行！");
        };
     /*   }catch (Exception e){
            return Result.success(JSONObject.toJSONString(e));
        }*/
    }
}
