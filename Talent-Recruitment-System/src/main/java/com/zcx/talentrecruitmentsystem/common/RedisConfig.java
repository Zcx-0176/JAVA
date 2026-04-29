package com.zcx.talentrecruitmentsystem.common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import tools.jackson.databind.ObjectMapper;

/*
    Redis配置类
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){

        //创建一个新的Redis遥控器，即Redis操作工具
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();

        //连接Redis服务，没有它，这个对象连接不到Redis
        redisTemplate.setConnectionFactory(factory);


        //设置key序列化和不乱码
        //即使用String存储
        //第一行的代码，是让普通的键值对的key不乱码，即name: zcx,age: 18，单独的key:如name和age
        //第二行的代码，是让对象里的好多key不乱码，即user1: name: zcx, age:20，包含在user1这个对象的key：如user1.name user1.age
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());

        //设置value序列化和不乱码
        //即使用JSON格式存储
        redisTemplate.setValueSerializer(RedisSerializer.json());
        redisTemplate.setHashValueSerializer(RedisSerializer.json());

        //让设置生效
        redisTemplate.afterPropertiesSet();

        //把改造好的遥控器交给spring管理
        return redisTemplate;
    }
}
