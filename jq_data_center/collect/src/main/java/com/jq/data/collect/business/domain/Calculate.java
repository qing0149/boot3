package com.jq.data.collect.business.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Calculate implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long ruleId;

    private String enName;

    /**
     * 元数据
     */
    private Metadata metadata;

    private List<String> parameters;

    private String func;

    private String expression;

}