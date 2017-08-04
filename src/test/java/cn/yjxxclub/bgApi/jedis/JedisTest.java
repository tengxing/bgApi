package cn.yjxxclub.bgApi.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-8-1
 * Time: 下午8:11
 * Describe: Jedis测试
 */
public class JedisTest {
    private final static Logger logger = LoggerFactory.getLogger(JedisTest.class);


    public static JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(50);
        config.setMinIdle(20);
        config.setMaxWaitMillis(6 * 1000);
        config.setTestOnBorrow(true);
        return config;
    }

    public static void main(String[] args){
        JedisPoolConfig jedisPoolConfig = jedisPoolConfig();
        Jedis jedis = new Jedis("localhost");
        logger.info("时间"+new Date().getTime());
        for (int i=0;i<100000;i++) {
            jedis.set("foo" + i, "bar" + i);
            String value = jedis.get("foo" + i);
        }
        logger.info("时间"+new Date().getTime());

    }


}
