package com.jq.data.example.mapping.package2.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-02-16 11:35
 **/
@Getter
@AllArgsConstructor
public enum ClassEnum {
    ONE("一年级", 1),
    TWO("二年级", 2),
    THREE("二年级", 2);
    private final String className;
    private final Integer value;
}
