package com.cheny.findFriend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheny.findFriend.model.entity.UserTeam;
import com.cheny.findFriend.service.UserTeamService;
import com.cheny.findFriend.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
* @author chen
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2024-02-13 21:05:12
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




