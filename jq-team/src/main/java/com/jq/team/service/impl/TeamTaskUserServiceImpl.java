package com.jq.team.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jq.team.domain.TeamTaskUser;
import com.jq.team.mapper.TeamTaskUserMapper;
import com.jq.team.service.TeamTaskUserService;
import org.springframework.stereotype.Service;

/**
* @author 30627
* @description 针对表【team_task_user(任务和参与人关系表)】的数据库操作Service实现
* @createDate 2024-03-03 18:12:10
*/
@Service
public class TeamTaskUserServiceImpl extends ServiceImpl<TeamTaskUserMapper, TeamTaskUser>
    implements TeamTaskUserService {

}




