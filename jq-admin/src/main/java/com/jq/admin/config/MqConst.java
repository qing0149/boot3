package com.jq.admin.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Date 2024/3/21 11:29
 */
@Component
@ConfigurationProperties(prefix = "mq") //和配置文件person前缀的所有配置进行绑定
@Data //自动生成JavaBean属性的getter/setter
public class MqConst {
    public static String hebei1;

    @Value("${mq.hebei1}")
    public void setHebei1(String hebei1) {
        MqConst.hebei1 = hebei1;
    }

}
