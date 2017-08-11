package cn.yjxxclub.bgApi.common.config;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-8-6
 * Time: 上午1:07
 * Describe: 自定义缓存Key生成策略 默认key:类名-方法名
 */
public class CacheKeyGenerator implements KeyGenerator{
    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuilder key = new StringBuilder();
        key.append(target.getClass().getName());
        key.append("-");
        key.append(method.getName());
        /*for (Object obj : params) {
            key.append(obj.toString());
        }*/
        return key.toString();
    }
}
