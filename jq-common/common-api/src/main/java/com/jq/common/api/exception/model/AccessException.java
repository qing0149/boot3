/**
 * chengyun.com
 * Copyright (c) 2023 All Rights Reserved.
 */
package com.jq.common.api.exception.model;

import com.jq.common.api.constant.ResultStatusCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 异常定义
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class AccessException extends Exception {

    @Serial
    private static final long serialVersionUID = 5442812001186752601L;

    private ResultStatusCode resultStatusCode;
}
