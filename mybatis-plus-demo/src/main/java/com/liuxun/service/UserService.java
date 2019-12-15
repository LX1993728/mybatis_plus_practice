/**
 * @filename:UserService 2019年9月14日
 * @project my-test  V1.0
 * Copyright(c) 2020 liuxun Co. Ltd. 
 * All right reserved. 
 */
package com.liuxun.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liuxun.domain.User;
import com.liuxun.domain.po.UserBookItem;
import com.liuxun.domain.vo.UserBookItemParam;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 用户服务层</P>
 * @version: V1.0
 * @author: liuxun
 * 
 */
public interface UserService extends IService<User> {
	Page<UserBookItem> selectUserListByPage(UserBookItemParam itemParam);
}