package com.puxinxiaolin.application.convert;

import com.puxinxiaolin.application.dto.GoodsDTO;
import com.puxinxiaolin.domain.bo.GoodsBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GoodsDTOConverter {

    GoodsDTOConverter INSTANCE = Mappers.getMapper(GoodsDTOConverter.class);

    /**
     * GoodsDTO -> GoodsBO
     *
     * @param goodsDTO
     * @return
     */
    GoodsBO convertDTO2BO(GoodsDTO goodsDTO);

    /**
     * List<GoodsBO> -> List<GoodsDTO>
     *
     * @param goodsBOList
     * @return
     */
    List<GoodsDTO> convertBO2DTOList(List<GoodsBO> goodsBOList);
}
