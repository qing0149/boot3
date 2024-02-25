package com.jq.wp.file.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jq.wp.file.domain.model.PanFileChunk;
import com.jq.wp.file.mapper.PanFileChunkMapper;
import com.jq.wp.file.service.PanFileChunkService;
import org.springframework.stereotype.Service;

/**
 * @author 30627
 * @description 针对表【pan_file_chunk(文件分片信息表)】的数据库操作Service实现
 * @createDate 2024-02-26 00:24:45
 */
@Service(value = "panFileChunkService")
public class PanFileChunkServiceImpl extends ServiceImpl<PanFileChunkMapper, PanFileChunk>
        implements PanFileChunkService {

}




