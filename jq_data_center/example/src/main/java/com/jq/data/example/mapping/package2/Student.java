package com.jq.data.example.mapping.package2;

import com.jq.data.example.mapping.package2.enums.ClassEnum;
import com.jq.data.example.mapping.package2.enums.SexEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-02-16 10:37
 **/
@Data
public class Student {

    private Long id;

    private ClassEnum classEnum;

    private String name;

    private String fullName;

    private SexEnum sexEnum;

    private Integer age;

    private Dog dog;

}
