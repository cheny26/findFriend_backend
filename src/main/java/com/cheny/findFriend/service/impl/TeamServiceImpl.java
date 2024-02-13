package com.cheny.findFriend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheny.findFriend.common.ErrorCode;
import com.cheny.findFriend.exception.BusinessException;
import com.cheny.findFriend.model.dto.team.TeamAddRequest;
import com.cheny.findFriend.model.entity.Team;
import com.cheny.findFriend.model.entity.User;
import com.cheny.findFriend.model.entity.UserTeam;
import com.cheny.findFriend.model.enums.TeamStatusEnum;
import com.cheny.findFriend.service.TeamService;
import com.cheny.findFriend.mapper.TeamMapper;
import com.cheny.findFriend.service.UserService;
import com.cheny.findFriend.service.UserTeamService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
* @author chen
* @description 针对表【team(队伍)】的数据库操作Service实现
* @createDate 2024-02-13 21:04:37
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
    implements TeamService{


    @Resource
    private UserTeamService userTeamService;

    @Override
    @Transactional
    public long addTeam(Team team, User loginUser) {
        if(team==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if(loginUser==null){
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR,"请先登录");
        }
        long userId=loginUser.getId();
        QueryWrapper<Team> query = new QueryWrapper<>();
        query.eq("userId",userId);
        long count=this.count(query);
        if(count>5){
            throw new BusinessException(ErrorCode.OPERATION_ERROR,"创建队伍过多");
        }
        String teamName=team.getTeamName();
        if(StringUtils.isBlank(teamName) || teamName.length()>20){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"队伍名称不符合要求");
        }
        String description=team.getTeamDescription();
        if(description.length()>512){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"队伍描述过长");
        }
        int max=team.getMaxNum();
        if(max<1 || max>10){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"队伍人数错误");
        }
        if(team.getExpireTime().before(new Date())){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"超时时间错误");
        }
        TeamStatusEnum enumByValue = TeamStatusEnum.getEnumByValue(team.getTeamStatus());
        if(enumByValue==TeamStatusEnum.SECRET){
            if(team.getTeamPassword()==null || team.getTeamPassword().length()>32){
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"请设置正确密码");
            }
        }
        team.setId(null);
        team.setUserId(loginUser.getId());
        boolean result = this.save(team);
        Long teamId = team.getId();
        if(!result || teamId==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"创建队伍失败");
        }
        UserTeam userTeam=new UserTeam();
        userTeam.setTeamId(teamId);
        userTeam.setUserId(userId);
        userTeam.setJoinTime(new Date());
        result = userTeamService.save(userTeam);
        if (!result) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "创建队伍失败");
        }
        return teamId;
    }
}




