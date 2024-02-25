package com.jq.wp.file.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jq.wp.file.domain.model.PanFile;
import com.jq.wp.file.mapper.PanFileMapper;
import com.jq.wp.file.service.PanFileService;
import org.springframework.stereotype.Service;

/**
 * @author 30627
 * @description 针对表【pan_file(物理文件信息表)】的数据库操作Service实现
 * @createDate 2024-02-26 00:24:45
 */
@Service(value = "panFileService")
public class PanFileServiceImpl extends ServiceImpl<PanFileMapper, PanFile>
        implements PanFileService {

}




