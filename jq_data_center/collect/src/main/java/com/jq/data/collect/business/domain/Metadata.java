package com.jq.data.collect.business.domain;

import com.jq.data.collect.enums.DataTypeEnum;
import com.jq.data.collect.enums.SourceTypeEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Objects;

@Data
@Slf4j
public class Metadata implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long ruleId;

    private String enName;

    private String cnName;

    private Boolean defaultShow;

    private Boolean storage;

    private Boolean dimension;

    private Boolean period;

    private DataTypeEnum dataType;

    private SourceTypeEnum sourceType;

    private Integer lifeCycleRuleId;

    private String traceId;

    private Integer dataSecurity;

    private Integer extraWidth;

    private String description;

    private Integer rank;

    private Integer baseValue;

    public Object getDefaultValue() {
        Object result = null;
        try {
            if (Objects.isNull(dataType)) {
                return result;
            }
            if (Objects.equals(dataType, DataTypeEnum.DATE) || Objects.equals(dataType, DataTypeEnum.TIMESTAMP)) {
                return new Date();
            }
            Class<?> javaType = dataType.getJavaType();
            result = javaType.getDeclaredConstructor(String.class).newInstance(dataType.getDbDefaultValue());
        } catch (Exception e) {
            log.error("getDefaultValue err e=", e);
        }
        return result;
    }

    public static void main(String[] args) {
        Metadata metadata = new Metadata();
        metadata.setDataType(DataTypeEnum.INTEGER);
        Object defaultValue = metadata.getDefaultValue();
        System.out.println(defaultValue);
    }
}