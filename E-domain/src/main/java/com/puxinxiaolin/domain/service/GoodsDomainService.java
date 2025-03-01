package com.puxinxiaolin.domain.service;

import com.puxinxiaolin.common.entity.PageResult;
import com.puxinxiaolin.domain.bo.GoodsBO;

public interface GoodsDomainService {

    Boolean add(GoodsBO goodsBO);

    PageResult<GoodsBO> getGoodsPage(GoodsBO goodsBO);

}
