package cn.yjxxclub.bgApi.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-8-6
 * Time: 下午12:46
 * Describe: redis sentinel集群配置
 */
@Configuration
@PropertySource(value = {"classpath:redis.properties"})
public class RedisConfig {

    @Resource
    Environment ev;

    /**
     * jedis pool配置
     * @return
     */
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig= new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(ev.getProperty("redis.pool.maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(ev.getProperty("redis.pool.maxIdle")));
        jedisPoolConfig.setMaxWaitMillis(Long.parseLong(ev.getProperty("redis.pool.maxWaitMillis")));
        jedisPoolConfig.setTestOnBorrow(ev.getProperty("redis.pool.testOnBorrow").equals("true"));
        return jedisPoolConfig;
    }

    /**
     * redis sentinel集群配置
     * @return
     */
    @Bean
    public RedisSentinelConfiguration redisSentinelConfiguration(){
        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
        RedisNode sentinel1= new RedisNode(ev.getProperty("redis.sentinel.host1"),Integer.parseInt(ev.getProperty("redis.sentinel.port1")));
        RedisNode sentinel2= new RedisNode(ev.getProperty("redis.sentinel.host2"),Integer.parseInt(ev.getProperty("redis.sentinel.port2")));
        Set<RedisNode> redisNodes = new HashSet();
        redisNodes.add(sentinel1);
        redisNodes.add(sentinel2);
        redisSentinelConfiguration.setMaster(ev.getProperty("redis.master.name"));
        redisSentinelConfiguration.setSentinels(redisNodes);
        return redisSentinelConfiguration;
    }

    /**
     * jedis 连接工厂
     * @return
     */
    @Bean
    public JedisConnectionFactory redisConnectionFactory(RedisSentinelConfiguration redisSentinelConfiguration,JedisPoolConfig jedisPoolConfig){
        JedisConnectionFactory factory = new JedisConnectionFactory(redisSentinelConfiguration,jedisPoolConfig);
        /*factory.setHostName();
        factory.setPort();
        factory.setPassword();
        factory.setTimeout();
        factory.setPoolConfig(jedisPoolConfig);*/
        return factory;
    }

    /**
     * redis 模板
     * @return
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(cf);
        return redisTemplate;
    }

}
