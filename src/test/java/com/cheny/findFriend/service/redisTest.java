package com.cheny.findFriend.service;


import com.cheny.findFriend.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;


/**
 * @author chen_y
 * @date 2024-02-12 20:58
 */
@SpringBootTest
public class redisTest {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test(){
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("string","字符串值");
        valueOperations.set("int",123);
        User user=new User();
        user.setId(1L);
        user.setUserName("testName");
        valueOperations.set("user",user);
        User user1 = (User)valueOperations.get("user");
        System.out.println(user1);
    }
}
