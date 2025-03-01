package com.puxinxiaolin.infra.basic.service.impl;

import com.puxinxiaolin.infra.basic.entity.Goods;
import com.puxinxiaolin.infra.basic.mapper.GoodsDao;
import com.puxinxiaolin.infra.basic.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * (TGoods)表服务实现类
 *
 * @author makejava
 * @since 2025-03-01 11:46:06
 */
@Service("tGoodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Goods queryById(Long id) {
        return this.goodsDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Goods goods) {
        return this.goodsDao.insert(goods);
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods update(Goods goods) {
        this.goodsDao.update(goods);
        return this.queryById(goods.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.goodsDao.deleteById(id) > 0;
    }

    @Override
    public int countByCondition(Goods goods) {
        return this.goodsDao.countByCondition(goods);
    }

    @Override
    public List<Goods> queryPage(Goods goods, int start, Integer pageSize) {
        return this.goodsDao.queryPage(goods, start, pageSize);
    }
}
