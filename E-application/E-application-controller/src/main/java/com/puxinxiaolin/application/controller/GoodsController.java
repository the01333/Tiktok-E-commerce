package com.puxinxiaolin.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.puxinxiaolin.application.convert.GoodsDTOConverter;
import com.puxinxiaolin.application.dto.GoodsDTO;
import com.puxinxiaolin.common.entity.PageResult;
import com.puxinxiaolin.common.entity.Result;
import com.puxinxiaolin.domain.bo.GoodsBO;
import com.puxinxiaolin.domain.service.GoodsDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/goods")
@RestController
@Slf4j
public class GoodsController {

    @Resource
    private GoodsDomainService goodsDomainService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody GoodsDTO goodsDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("GoodsController.add.dto:{}", JSON.toJSONString(goodsDTO));
            }

            Preconditions.checkArgument(StringUtils.isNotBlank(goodsDTO.getGoodsName()), "商品名称不能为空");
            Preconditions.checkNotNull(goodsDTO.getPrice(), "商品价格不能为空");
            Preconditions.checkNotNull(goodsDTO.getType(), "商品类型不能为空");
            Preconditions.checkNotNull(goodsDTO.getStock(), "商品库存不能为空");

            GoodsBO goodsBO = GoodsDTOConverter.INSTANCE
                    .convertDTO2BO(goodsDTO);
            Boolean result = goodsDomainService.add(goodsBO);

            return Result.ok(result);
        } catch (Exception e) {
            log.warn("GoodsController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增商品失败");
        }
    }

    @PostMapping("/getGoodsPage")
    public Result<List<GoodsDTO>> getGoodsPage(@RequestBody GoodsDTO goodsDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("GoodsController.getGoodsPage.dto:{}", JSON.toJSONString(goodsDTO));
            }

            Preconditions.checkNotNull(goodsDTO.getType(), "商品分类不能为空");

            GoodsBO goodsBO = GoodsDTOConverter.INSTANCE
                    .convertDTO2BO(goodsDTO);
            PageResult<GoodsBO> goodsBOList = goodsDomainService.getGoodsPage(goodsBO);
            // TODO [YCcLin 2025/3/1]: 还需要转一次

            return Result.ok(goodsBOList);
        } catch (Exception e) {
            log.warn("GoodsController.getGoodsPage.error:{}", e.getMessage(), e);
            return Result.fail("分页查询商品失败");
        }
    }

}
