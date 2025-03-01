package com.puxinxiaolin.common.entity;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @description: 分页返回实体
 * @author: YCcLin
 * @date: 2025/2/17
 **/
@Data
public class PageResult<T> {

    private Integer pageNo = 1;

    private Integer pageSize = 20;

    /**
     * 总条数
     */
    private Integer total = 0;

    /**
     * 总页数
     */
    private Integer totalPages = 0;

    /**
     * 返回结果
     */
    private List<T> result = Collections.emptyList();

    /**
     * 当前页的起始记录索引
     */
    private Integer start = 1;

    /**
     * 当前页的结束记录索引
     */
    private Integer end = 0;

    public void setRecords(List<T> records) {
        this.result = records;
        if (records != null && !records.isEmpty()) {
            setTotal(records.size());
        }
    }

    public void setTotal(Integer total) {
        this.total = total;
        if (this.pageSize > 0) {
            this.totalPages = total / this.pageSize + total % this.pageSize == 0 ? 0 : 1;
        } else {
            this.totalPages = 0;
        }

        this.start = (this.pageSize > 0 ? (this.pageNo - 1) * this.pageSize : 0) + 1;
        this.end = (this.start - 1 + this.pageSize * (this.pageNo > 0 ? 1 : 0));
    }

}
