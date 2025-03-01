package com.puxinxiaolin.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.puxinxiaolin.common.entity.PageResult;
import com.puxinxiaolin.common.enums.IsDeletedEnum;
import com.puxinxiaolin.common.enums.StatusEnum;
import com.puxinxiaolin.domain.bo.GoodsBO;
import com.puxinxiaolin.domain.converter.GoodsBOConverter;
import com.puxinxiaolin.domain.service.GoodsDomainService;
import com.puxinxiaolin.infra.basic.entity.Goods;
import com.puxinxiaolin.infra.basic.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class GoodsDomainServiceImpl implements GoodsDomainService {

    @Resource
    private GoodsService goodsService;

    @Override
    public Boolean add(GoodsBO goodsBO) {
        if (log.isInfoEnabled()) {
            log.info("GoodsDomainServiceImpl.add.bo:{}", JSON.toJSONString(goodsBO));
        }

        Goods goods = GoodsBOConverter.INSTANCE
                .convertBO2Entity(goodsBO);
        goods.setStatus(StatusEnum.OPEN.getCode());
        goods.setIsDeleted(IsDeletedEnum.UN_DELETED.getCode());
        // TODO [YCcLin 2025/3/1]: 后期通过统一拦截器来实现公共字段注入
        goods.setCreateTime(new Date());
        goods.setUpdateTime(new Date());
        goods.setCreatedBy("admin");
        goods.setUpdatedBy("admin");
        int count = goodsService.insert(goods);

        return count > 0;
    }

    @Override
    public PageResult<GoodsBO> getGoodsPage(GoodsBO goodsBO) {
        if (log.isInfoEnabled()) {
            log.info("GoodsDomainServiceImpl.getGoodsPage.bo:{}", JSON.toJSONString(goodsBO));
        }

        PageResult<GoodsBO> pageResult = new PageResult<>();
        pageResult.setPageNo(goodsBO.getPageNo());
        pageResult.setPageSize(goodsBO.getPageSize());

        int start = (goodsBO.getPageNo() - 1) * goodsBO.getPageSize();

        Goods goods = GoodsBOConverter.INSTANCE
                .convertBO2Entity(goodsBO);
        goods.setIsDeleted(IsDeletedEnum.UN_DELETED.getCode());
        goods.setStatus(StatusEnum.OPEN.getCode());
        int count = goodsService.countByCondition(goods);
        if (count == 0) {
            return pageResult;
        }

        List<Goods> goodsList = goodsService.queryPage(goods, start, goodsBO.getPageSize());
        List<GoodsBO> goodsBOList = GoodsBOConverter.INSTANCE
                .convertEntityList2BOList(goodsList);

        pageResult.setRecords(goodsBOList);
        pageResult.setTotal(count);
        return pageResult;
    }
}
