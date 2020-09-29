/**
 * @filename:BookServiceImpl 2019年9月14日
 * @project my-test  V1.0
 * Copyright(c) 2018 liuxun Co. Ltd. 
 * All right reserved. 
 */
package com.liuxun.service.serviceImpl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuxun.domain.Book;
import com.liuxun.mapper.BookMapper;
import com.liuxun.service.BookService;
import org.springframework.stereotype.Service;

/**   
 *
 * 
 * <p>说明： 书服务实现层</P>
 * @version: V1.0
 * @author: liuxun
 * 
 */
@DS("db2")
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService  {
	
}