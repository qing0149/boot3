package com.jq.wp.file.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jq.common.api.constant.RPanConstants;
import com.jq.common.api.exception.model.ServiceException;
import com.jq.wp.file.constants.FileConstants;
import com.jq.wp.file.context.CreateFolderContext;
import com.jq.wp.file.domain.model.PanUserFile;
import com.jq.wp.file.enums.DelFlagEnum;
import com.jq.wp.file.enums.FolderFlagEnum;
import com.jq.wp.file.mapper.PanUserFileMapper;
import com.jq.wp.file.service.PanUserFileService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 30627
 * @description 针对表【pan_user_file(用户文件信息表)】的数据库操作Service实现
 * @createDate 2024-02-26 12:54:45
 */
@Service
public class PanUserFileServiceImpl extends ServiceImpl<PanUserFileMapper, PanUserFile>
        implements PanUserFileService {

    @Override
    public Long createFolder(CreateFolderContext cxt) throws ServiceException {
        return saveUserFile(cxt.getParentId(),
                cxt.getFolderName(),
                FolderFlagEnum.YES, null, null,
                cxt.getUserId(),
                null);
    }

    //------------private

    /**
     * 保存文件的映射记录
     *
     * @param parentId
     * @param fileName
     * @param folderFlagEnum
     * @param fileType
     * @param realFileId
     * @param userId
     * @param fileSizeDesc
     * @return
     * @throws ServiceException
     */
    private Long saveUserFile(Long parentId,
                              String fileName,
                              FolderFlagEnum folderFlagEnum,
                              Integer fileType,
                              Long realFileId,
                              Long userId,
                              String fileSizeDesc) throws ServiceException {
        PanUserFile entity = assemblePanUserFile(parentId, userId, fileName, folderFlagEnum, fileType, realFileId, fileSizeDesc);
        if (!this.save(entity)) {
            throw new ServiceException("保存文件信息失败");
        }
        return entity.getId();
    }

    /**
     * 用户文件映射关系实体
     * 1.构建并填充实体
     * 2.处理文件名一直的问题
     * a->b ,b(2)
     *
     * @param parentId
     * @param userId
     * @param fileName
     * @param folderFlagEnum
     * @param fileType
     * @param realFileId
     * @param fileSizeDesc
     * @return
     */

    private PanUserFile assemblePanUserFile(Long parentId, Long userId, String fileName, FolderFlagEnum folderFlagEnum,
                                            Integer fileType, Long realFileId, String fileSizeDesc) {
        PanUserFile entity = new PanUserFile();
//        panUserFile.setId(Id);
        entity.setUserId(userId);
        entity.setParentId(parentId);
        entity.setRealFileId(realFileId);
        entity.setFileName(fileName);
        entity.setFolderFlag(folderFlagEnum.getCode());
        entity.setFileType(fileType);
        entity.setDelFlag(DelFlagEnum.NO.getCode());
        entity.setRealFileId(realFileId);
        entity.setFileSizeDesc(fileSizeDesc);
        entity.setCreateUser(userId);
        entity.setCreateTime(new Date());
        entity.setUpdateUser(userId);
        entity.setUpdateTime(new Date());
//      处理重复名字
        handleDuplicateFileName(entity);
        return entity;
    }

    /**
     * 处理用户重复名称
     * 如果同一个文件夹下面有文件名称重复
     * 按照系统级重命名文件
     *
     * @param entity
     */
    private void handleDuplicateFileName(PanUserFile entity) {
        String fileName = entity.getFileName(),
                newFileNameWithoutSuffix,
                newFileNameSuffix;
        int newFileNamePointPosition = fileName.lastIndexOf(RPanConstants.POINT_STR);
        if (newFileNamePointPosition == RPanConstants.MINUS_ONE_INT) {
            newFileNameWithoutSuffix = fileName;
            newFileNameSuffix = StrUtil.EMPTY;
        } else {
            newFileNameWithoutSuffix = fileName.substring(RPanConstants.ZERO_INT, newFileNamePointPosition);
            newFileNameSuffix = fileName.replace(newFileNameWithoutSuffix, StrUtil.EMPTY);
        }
        long count = getDuplicateFileName(entity, newFileNameSuffix);
        if (count == 0) {
            return;
        }
        String newFileName = assembleNewFileName(newFileNameWithoutSuffix, count, newFileNameSuffix);
        entity.setFileName(newFileName);
    }

    /**
     * 拼装新文件名称
     * 拼装规则操作系统重复文件名称的重复命名规范
     * @param newFileNameWithoutSuffix
     * @param count
     * @param newFileNameSuffix
     * @return
     */
    private String assembleNewFileName(String newFileNameWithoutSuffix, long count, String newFileNameSuffix) {
       return newFileNameWithoutSuffix+
               FileConstants.CN_LEFT_PARENTHESES_STR +
               count +
               FileConstants.CN_RIGHT_PARENTHESES_STR+
               newFileNameSuffix;
    }

    /**
     * 查找统一文件夹下面的同名文件数量
     *
     * @param entity
     * @param newFileNameSuffix
     * @return
     */
    private Long getDuplicateFileName(PanUserFile entity, String newFileNameSuffix) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("parent_id", entity.getParentId());
        qw.eq("folder_flag", entity.getFolderFlag());
        qw.eq("user_id", entity.getParentId());
        qw.eq("del_flag", DelFlagEnum.NO.getCode());
        qw.eq("parent_id", entity.getParentId());
        qw.likeLeft("filename", newFileNameSuffix);
        return count(qw);
    }
}




