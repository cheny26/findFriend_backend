package com.cheny.findFriend.model.dto.team;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chen_y
 * @date 2024-02-13 21:37
 */
@Data
public class TeamAddRequest implements Serializable {

    private static final long serialVersionUID = -8077745866368835869L;
    /**
     * 队伍名称
     */
    private String teamName;

    /**
     * 描述
     */
    private String teamDescription;

    /**
     * 最大人数
     */
    private Integer maxNum;

    /**
     * 过期时间
     */
    private Date expireTime;


    /**
     * 0 - 公开，1 - 私有，2 - 加密
     */
    private Integer teamStatus;

    /**
     * 密码
     */
    private String teamPassword;



}
