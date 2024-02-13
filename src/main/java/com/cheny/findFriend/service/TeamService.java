package com.cheny.findFriend.service;

import com.cheny.findFriend.model.dto.team.TeamAddRequest;
import com.cheny.findFriend.model.entity.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cheny.findFriend.model.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
* @author chen
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2024-02-13 21:04:37
*/
public interface TeamService extends IService<Team> {
    long addTeam(Team team, User loginUser);
}
