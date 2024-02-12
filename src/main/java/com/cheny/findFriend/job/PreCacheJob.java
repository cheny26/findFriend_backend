package com.cheny.findFriend.job;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cheny.findFriend.model.entity.User;
import com.cheny.findFriend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author chen_y
 * @date 2024-02-12 22:44
 */
@Component
@Slf4j
public class PreCacheJob {
    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    // 重点用户
    private List<Long> mainUserList = Arrays.asList(1L);

    // 每天执行，预热推荐用户
    @Scheduled(cron = "0 31 0 * * *")
    public void doCacheRecommendUser() {
        for(long userId:mainUserList){
            Page<User> userPage = userService.page(new Page<>(1, 15));
            String redisKey = String.format("findFriend:user:recommend:%s", userId);
            ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
            // 写缓存
            try {
                valueOperations.set(redisKey, userPage, 6, TimeUnit.HOURS);
            } catch (Exception e) {
                log.error("redis set key error", e);
            }
        }
    }
}
