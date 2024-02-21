package com.jq.data.example.mapping.package2;

import com.jq.data.example.mapping.package2.enums.SexEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-02-16 10:37
 **/
@Data
public class People {

    private String name;

    private SexEnum sexEnum;

    private Integer age;


    private Dog dog;

}
