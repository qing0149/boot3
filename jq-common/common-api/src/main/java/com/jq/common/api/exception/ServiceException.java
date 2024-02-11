package com.jq.common.api.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-02-06 11:34
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends Exception {
    @Serial
    private static final long serialVersionUID = 2808584571270636402L;

    private Integer status = 100;

    private Object parameter;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }


    public ServiceException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message, Object parameter) {
        super(message);
        this.parameter = parameter;
    }

    public ServiceException(Integer status, String message, Object parameter) {
        super(message);
        this.status = status;
        this.parameter = parameter;
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression,
                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
