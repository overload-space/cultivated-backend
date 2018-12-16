package com.cultivated.app.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Pagination
 * Author: zado
 * Description:
 * Change Log:
 * 17-12-14- created by zado
 */
@ApiModel(description = "分页结果")
public class Pagination {

    @ApiModelProperty("页码")
    private int page;

    @ApiModelProperty("记录总数")
    private int total;

    @ApiModelProperty("每页大小")
    private int size;

    public Pagination() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
