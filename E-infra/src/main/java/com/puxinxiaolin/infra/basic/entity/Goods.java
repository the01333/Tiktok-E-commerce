package com.puxinxiaolin.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (TGoods)实体类
 *
 * @author makejava
 * @since 2025-03-01 11:46:06
 */
@TableName("t_goods")
@Data
public class Goods implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 价格
     */
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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 修改人
     */
    private String updatedBy;

    /**
     * 是否删除 0:未删除 1:已删除
     */
    private Integer isDeleted;

}

