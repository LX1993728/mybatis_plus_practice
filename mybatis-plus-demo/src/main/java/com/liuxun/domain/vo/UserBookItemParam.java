package com.liuxun.domain.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuxun.domain.po.UserBookItem;
import lombok.Data;

/**
 * @author liuxun
 */

@Data
public class UserBookItemParam extends UserBookItem {
    private long pageSize;
    private long pageNum;
    private String sortedField;
    private boolean isDesc =  false;
}
