/**
 * @filename:Book 2019年9月14日
 * @project my-test  V1.0
 * Copyright(c) 2020 liuxun Co. Ltd. 
 * All right reserved. 
 */
package com.liuxun.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 书实体类</P>
 * @version: V1.0
 * @author: liuxun
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Book extends Model<Book> {

	private static final long serialVersionUID = 1576376900501L;
	
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(name = "id" , value = "")
	private Long id;
    
	@ApiModelProperty(name = "bookName" , value = "书名")
	private String bookName;
    
	@ApiModelProperty(name = "author" , value = "作者")
	private String author;
    
	@Override
    protected Serializable pkVal() {
        return this.id;
    }
}
