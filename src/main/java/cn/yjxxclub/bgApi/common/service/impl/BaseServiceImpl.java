package cn.yjxxclub.bgApi.common.service.impl;

import cn.yjxxclub.bgApi.common.mapper.BaseMapper;
import cn.yjxxclub.bgApi.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-7-26
 * Time: 下午10:48
 * Describe: BaseService实现类
 */
public class BaseServiceImpl<S extends BaseMapper,T> implements BaseService<T> {

    @Autowired
    BaseMapper<T> baseMapper;

    @Override
    public Integer add(T entity) {
        return baseMapper.add(entity);
    }

    @Override
    public Integer update(T entity) {
        return baseMapper.update(entity);
    }

    @Override
    public long countTotal() {
        return baseMapper.countTotal();
    }

    @Override
    public List listTotal() {
        return baseMapper.listTotal();
    }

    @Override
    public Integer deleteById(Integer id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public Integer delete(Map map) {
        return baseMapper.delete(map);
    }

    @Override
    public List listByPage(Map map) {
        return baseMapper.listByPage(map);
    }
}
