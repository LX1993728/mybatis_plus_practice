/**
 * @filename:UserController 2019年9月14日
 * @project my-test  V1.0
 * Copyright(c) 2020 liuxun Co. Ltd. 
 * All right reserved. 
 */
package com.liuxun.controllers;

import com.liuxun.aid.AbstractController;
import com.liuxun.domain.User;
import com.liuxun.service.UserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 用户API接口层</P>
 * @version: V1.0
 * @author: liuxun
 * @time    2019年9月14日
 *
 */
@Api(description = "用户",value="用户" )
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<UserService,User>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
}