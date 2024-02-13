package com.cheny.findFriend.service;

import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author chen_y
 * @date 2024-02-13 10:24
 */
@SpringBootTest
public class RedissonTest {
    @Resource
    private RedissonClient redissonClient;

    @Test
    public void test() {
        RList<Object> testList = redissonClient.getList("testList");
        testList.add(123);
        System.out.println(testList.get(0));
    }
}
