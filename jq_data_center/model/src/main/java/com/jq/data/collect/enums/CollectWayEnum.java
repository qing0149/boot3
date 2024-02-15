package com.jq.data.collect.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Tim
 * @Description:
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum CollectWayEnum {
    SQL("sql抽取",1),
    INTERFACE("接口抽取",2);

    private static final Map<Integer, CollectWayEnum> sourceMap = Arrays.asList(values()).stream().collect(Collectors.toMap(CollectWayEnum::getSourceValue, v->v));

    private final String sourceType;
    private final Integer sourceValue;

    public static CollectWayEnum parse(Integer sourceValue){
        return sourceMap.get(sourceValue);
    }
}
