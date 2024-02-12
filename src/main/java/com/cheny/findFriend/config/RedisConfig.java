package com.cheny.findFriend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;

@Configuration
public class RedisConfig {
    @Resource
    private RedisConnectionFactory connectionFactory;


    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        // 创建 RedisTemplate 对象
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 设置连接工厂
        redisTemplate.setConnectionFactory(connectionFactory);
        // 设置Key的序列化 - String 序列化 RedisSerializer.string() =>StringRedisSerializer.UTF_8
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        return redisTemplate;
    }
}
