package cn.yjxxclub.bgApi.common.service;

import java.util.List;
import java.util.Map;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-7-26
 * Time: 下午10:47
 * Describe: 基础Service接口
 */
public interface BaseService<T> {

    /**
     * 增加
     * @param entity
     * @return
     */
    Integer add(T entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    Integer update(T entity);

    /**
     * 所有条数
     * @return
     */
    long countTotal();

    /***
     * 分页
     * @param map
     * @return
     */
    List<T> listByPage(Map<String,Object> map);

    /**
     * 所有数据
     * @return
     */
    List<T> listTotal();

    /**
     * 通过id删除
     * @param id
     * @return
     */
    Integer deleteById(Integer id);

    /**
     * 删除
     * @param map
     * @return
     */
    Integer delete(Map<String,Object> map);

}
