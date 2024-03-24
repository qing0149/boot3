package com.jq.team.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jq.team.domain.TeamTask;
import com.jq.team.mapper.TeamTaskMapper;
import com.jq.team.service.TeamTaskService;
import org.springframework.stereotype.Service;

/**
* @author 30627
* @description 针对表【team_task(任务模块表)】的数据库操作Service实现
* @createDate 2024-03-03 18:12:10
*/
@Service
public class TeamTaskServiceImpl extends ServiceImpl<TeamTaskMapper, TeamTask>
    implements TeamTaskService {

}




