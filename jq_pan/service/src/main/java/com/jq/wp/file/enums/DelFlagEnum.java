package com.jq.wp.file.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName DelFlagEnum
 * @Description 文件删除标识枚举类
 * @Author
 * @Date 2024/2/26 18:35
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
public enum DelFlagEnum {
    NO(0),
    YES(1);
    private final Integer code;
}
