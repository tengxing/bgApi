package cn.yjxxclub.bgApi.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-8-6
 * Time: 下午3:51
 * Describe: 缓存配置
 */
@Configuration
@PropertySource(value = {"classpath:redis.properties"})
public class CacheConfig {

    @Resource
    Environment ev;

    /**
     * 缓存管理器
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(Integer.parseInt(ev.getProperty("redis.pool.expire")));// Sets the default expire time (in seconds)
        return cacheManager;
    }

    /**
     * 自定义缓存key生成策略
     * 默认:类名-方法名
     * @return
     */
    @Bean
    public KeyGenerator customKeyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append("-");
            sb.append(method.getName());
            /*for (Object obj : params) {
                sb.append(obj.toString());
            }*/
            return sb.toString();
        };
    }
}
