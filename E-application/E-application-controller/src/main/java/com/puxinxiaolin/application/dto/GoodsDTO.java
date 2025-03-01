package com.puxinxiaolin.application.dto;

import com.puxinxiaolin.common.entity.PageInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * (TGoods)实体类
 *
 * @author makejava
 * @since 2025-03-01 11:46:06
 */
@Data
public class GoodsDTO extends PageInfo implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 商品名称
     */
    private String goodsName;


    private Double price;

    /**
     * 商品类别 0:食物 1:日用品 2:商务电子 3:服装饰品 4:书籍
     */
    private Integer type;

    /**
     * 状态 0:禁用 1:启用
     */
    private Integer status;

    /**
     * 库存
     */
    private Integer stock;

}

