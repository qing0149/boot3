package com.jq.wp.file.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: Boot3
 * @description:文件夹标识枚举类
 * @author:
 * @create: 2024-02-26 13:43
 **/
@AllArgsConstructor
@Getter
public enum FolderFlagEnum {
    /**
     *非文件夹
     */
    NO(0),
    /**
     * 是文件家
     */
    YES(1)
    ;
    private final Integer code;
}
