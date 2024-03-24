package com.jq.team.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jq.team.domain.TeamProject;
import com.jq.team.mapper.TeamProjectMapper;
import com.jq.team.service.TeamProjectService;
import org.springframework.stereotype.Service;

/**
* @author 30627
* @description 针对表【team_project(项目创建表)】的数据库操作Service实现
* @createDate 2024-03-03 18:12:10
*/
@Service
public class TeamProjectServiceImpl extends ServiceImpl<TeamProjectMapper, TeamProject>
    implements TeamProjectService {

}




