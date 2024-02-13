package com.cheny.findFriend.controller;

import com.cheny.findFriend.common.BaseResponse;
import com.cheny.findFriend.common.ErrorCode;
import com.cheny.findFriend.common.ResultUtils;
import com.cheny.findFriend.exception.BusinessException;
import com.cheny.findFriend.model.dto.team.TeamAddRequest;
import com.cheny.findFriend.model.entity.Team;
import com.cheny.findFriend.model.entity.User;
import com.cheny.findFriend.service.TeamService;
import com.cheny.findFriend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author chen_y
 * @date 2024-02-13 22:36
 */
@RestController
@RequestMapping("/team")
@CrossOrigin(origins = {"http://localhost:5173"}, allowCredentials = "true")
@Slf4j
public class TeamController {
    @Resource
    private UserService userService;
    @Resource
    private TeamService teamService;

    @PostMapping("/add")
    public BaseResponse<Long> addTeam(@RequestBody TeamAddRequest teamAddRequest, HttpServletRequest request){
        if(teamAddRequest==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"请求参数错误");
        }
        User loginUser=userService.getLoginUser(request);
        Team team = new Team();
        BeanUtils.copyProperties(teamAddRequest, team);
        long id = teamService.addTeam(team, loginUser);
        return ResultUtils.success(id);
    }
}
