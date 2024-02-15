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
public enum SourceTypeEnum {
    COLLECT("抽取类型",1),
    CALCULATE("计算类型",2);
    private static final Map<Integer, SourceTypeEnum> sourceMap = Arrays.asList(values()).stream().collect(Collectors.toMap(SourceTypeEnum::getSourceValue, v->v));

    private final String sourceType;
    private final Integer sourceValue;

    public static SourceTypeEnum parse(Integer sourceValue){
        return sourceMap.get(sourceValue);
    }
}
