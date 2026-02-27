package com.scaler.productservicenamanbhallafeb24.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisTemplateConfig {

    @Bean
    public RedisTemplate<String,Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        /*
        here we are saying that datatype of key will be String (like ProductId)
        and value will be Object i.e. Product Object or category object or user object
        i might be using redis template for multiple type of object, so its better to keep it common as Object
        rather than specifying it as Product object or category object etc

         */

        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
