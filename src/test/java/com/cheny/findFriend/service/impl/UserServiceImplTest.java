package com.cheny.findFriend.service.impl;

import com.cheny.findFriend.model.vo.UserVO;
import com.cheny.findFriend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UserServiceImplTest {

    @Resource
    private UserService userService;
    @Test
    void findUsersByTags() {
        List<String> tags= Arrays.asList("java","vue");
        List<UserVO> usersByTags = userService.findUsersByTags(tags);
        for (UserVO user : usersByTags) {
            System.out.println(user);
        }
    }
}