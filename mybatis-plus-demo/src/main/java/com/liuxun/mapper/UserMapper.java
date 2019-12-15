/**
 * @filename:UserDao 2019年9月14日
 * @project my-test  V1.0
 * Copyright(c) 2020 liuxun Co. Ltd. 
 * All right reserved. 
 */
package com.liuxun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuxun.domain.User;
import com.liuxun.domain.po.UserBookItem;
import com.liuxun.domain.vo.UserBookItemParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * 
 * <p>说明： 用户数据访问层</p>
 * @version: V1.0
 * @author: liuxun
 * 
 */
public interface UserMapper extends BaseMapper<User> {
	List<UserBookItem> selectUserBookItems(Page page, @Param("param") UserBookItemParam param);
}
