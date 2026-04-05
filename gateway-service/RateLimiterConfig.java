package com.gateway.config;

import com.gateway.limiter.SlidingWindowHashMap;
import com.gateway.limiter.TokenBucketRedis;
import com.gateway.limiter.RateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 限流算法切换配置
 * 说明：想测试哪个版本，就解开哪个@Bean的注释，注释掉另一个
 * 到时候我们演示的时候建议先演示local（单机版），再改redis（分布式版）
 */
@Configuration
public class RateLimiterConfig {
    
    /*
     * 版本1：单机HashMap版（一开始写的那个滑动窗口旧版）
     */
    @Bean
    public RateLimiter rateLimiter() {
        return new SlidingWindowHashMap();
    }
    
    /*
     * 版本2：Redis令牌桶版（新版，分布式优化）
     */
    // @Bean
    // public RateLimiter rateLimiter() {
    //     return new TokenBucketRedis();
    // }
}
