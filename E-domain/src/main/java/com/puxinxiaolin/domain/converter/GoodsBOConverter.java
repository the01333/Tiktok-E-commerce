package com.puxinxiaolin.domain.converter;

import com.puxinxiaolin.domain.bo.GoodsBO;
import com.puxinxiaolin.infra.basic.entity.Goods;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GoodsBOConverter {

    GoodsBOConverter INSTANCE = Mappers.getMapper(GoodsBOConverter.class);

    /**
     * GoodsBO -> Goods
     *
     * @param goodsBO
     * @return
     */
    Goods convertBO2Entity(GoodsBO goodsBO);

    /**
     * List<Goods> -> List<GoodsBO>
     *
     * @param goodsList
     * @return
     */
    List<GoodsBO> convertEntityList2BOList(List<Goods> goodsList);
}
