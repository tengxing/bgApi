package cn.yjxxclub.bgApi.jedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-8-6
 * Time: 上午1:15
 * Describe: spring+redis serntinel高可用集群测试
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath*:redis.xml"})
public class SpringJedisSentinelTest {
    private static final Logger logger = LoggerFactory.getLogger(SpringJedisSentinelTest.class);

    @Resource
    RedisTemplate redisTemplate;

    @Test
    public void test() {
        /*boolean result = (boolean) redisTemplate.execute((RedisCallback) connection -> {
            connection.set("testKey".getBytes(), "test123".getBytes());
            return true;
        });*/
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        if (valueOps.get("testKey") == null) {
            valueOps.set("testKey", "test123");
            //logger.info("testKey:"+valueOps.get("testKey"));
        } else {
            logger.info("testKey:" + valueOps.get("testKey"));
        }

    }

}
