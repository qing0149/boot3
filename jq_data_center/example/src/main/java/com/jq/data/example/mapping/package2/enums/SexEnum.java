package com.jq.data.example.mapping.package2.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-02-16 10:38
 **/
@Getter
@AllArgsConstructor
public enum SexEnum {
    MAN("男",0),
    WOMAN("女",1),
    OTHER("其他",3),
    ;
    private final String name;
    private final Integer value;
}
