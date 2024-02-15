package com.jq.data.collect.business.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jq.data.collect.enums.CollectWayEnum;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@TableName(value ="t_data_center_collect")
@Data
public class Collect implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long ruleId;

    private String enName;

    private String dataSource;

    private CollectWayEnum collectWay;

    private String content;

    private Boolean deduplicate;

    private String periodFormat;

}