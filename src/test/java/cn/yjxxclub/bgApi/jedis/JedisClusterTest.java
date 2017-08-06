package cn.yjxxclub.bgApi.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import redis.clients.jedis.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-8-1
 * Time: 下午8:11
 * Describe: Jedis集群测试
 */
public class JedisClusterTest {
    private final static Logger logger = LoggerFactory.getLogger(JedisClusterTest.class);

    // Redis集群的节点集合
    static Set<HostAndPort> jedisClusterNodes;


    public static void main(String[] args){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(50);
        config.setMinIdle(20);
        config.setMaxWaitMillis(6 * 1000);
        config.setTestOnBorrow(true);

        jedisClusterNodes =new HashSet();
        jedisClusterNodes.add(new HostAndPort("localhost", 8001));
        jedisClusterNodes.add(new HostAndPort("localhost", 8002));
        jedisClusterNodes.add(new HostAndPort("localhost", 8003));
        jedisClusterNodes.add(new HostAndPort("localhost", 8004));
        jedisClusterNodes.add(new HostAndPort("localhost", 8005));
        jedisClusterNodes.add(new HostAndPort("localhost", 8006));
        //Jedis jedis = new Jedis("localhost");
        Set<String> sentinels = new HashSet<String>();
        sentinels.add("127.0.0.1:8101");
        sentinels.add("127.0.0.1:8201");

        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool("master-1",sentinels,config);

        Jedis jedis = jedisSentinelPool.getResource();
        logger.info("teng");
        for (int i=0;i<10000;i++){
            jedis.set("foo"+i, "bar"+i);
            String value = jedis.get("foo"+i);
            //jedisCluster.del("foo"+i);
        }
        jedis.set("foo8888","teng");
        logger.info(jedis.get("foo2"));
        /*JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes,config);
        logger.info("时间"+new Date().getTime());
        jedisCluster.set("name","tengxing");
        logger.info(jedisCluster.get("foo3"));
        for (int i=0;i<10000;i++){
            jedisCluster.set("foo"+i, "bar"+i);
            String value = jedisCluster.get("foo"+i);
            //jedisCluster.del("foo"+i);
        }*/
        logger.info("时间"+new Date().getTime());
    }
    @Cacheable(value = "")
    public String fdf(){
        return null;
    }

}
