package com.puxinxiaolin.infra.basic.service;

import com.puxinxiaolin.infra.basic.entity.Goods;

import java.util.List;

/**
 * (TGoods)表服务接口
 *
 * @author makejava
 * @since 2025-03-01 11:46:06
 */
public interface GoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Goods queryById(Long id);

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    int insert(Goods goods);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods update(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    int countByCondition(Goods goods);

    List<Goods> queryPage(Goods goods, int start, Integer pageSize);

}
