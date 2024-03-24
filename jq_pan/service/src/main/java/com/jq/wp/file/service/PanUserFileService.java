package com.jq.wp.file.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jq.common.api.exception.model.ServiceException;
import com.jq.wp.file.context.CreateFolderContext;
import com.jq.wp.file.domain.model.PanUserFile;

/**
 * @author 30627
 * @description 针对表【pan_user_file(用户文件信息表)】的数据库操作Service
 * @createDate 2024-02-26 12:54:45
 */
public interface PanUserFileService extends IService<PanUserFile> {
    /**
     * 创建文件夹信息
     * @return
     */
    Long createFolder(CreateFolderContext createFolderContext) throws ServiceException;

}
