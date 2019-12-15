/**
 * @filename:BookController 2019年9月14日
 * @project my-test  V1.0
 * Copyright(c) 2020 liuxun Co. Ltd. 
 * All right reserved. 
 */
package com.liuxun.controllers;

import com.liuxun.aid.AbstractController;
import com.liuxun.domain.Book;
import com.liuxun.service.BookService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 书API接口层</P>
 * @version: V1.0
 * @author: liuxun
 * @time    2019年9月14日
 *
 */
@Api(description = "书",value="书" )
@RestController
@RequestMapping("/book")
public class BookController extends AbstractController<BookService,Book>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
}