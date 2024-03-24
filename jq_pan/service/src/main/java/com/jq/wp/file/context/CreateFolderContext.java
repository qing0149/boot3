package com.jq.wp.file.context;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @program: Boot3
 * @description:创建文件夹上下文对象
 * @author:
 * @create: 2024-02-26 12:57
 **/
@Data
public class CreateFolderContext implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 父文件夹Id
     */
    private Long parentId;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 文件夹名称
     */
    private String folderName;
}
