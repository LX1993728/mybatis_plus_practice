/**
 * @filename:UserServiceImpl 2019年9月14日
 * @project my-test  V1.0
 * Copyright(c) 2018 liuxun Co. Ltd. 
 * All right reserved. 
 */
package com.liuxun.service.serviceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuxun.domain.User;
import com.liuxun.domain.po.UserBookItem;
import com.liuxun.domain.vo.UserBookItemParam;
import com.liuxun.mapper.UserMapper;
import com.liuxun.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * <p>自动生成工具：mybatis-dsc-generator</p> 
 * 
 * <p>说明： 用户服务实现层</P>
 * @version: V1.0
 * @author: liuxun
 * 
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService  {

    @Transactional(readOnly = true)
    @Override
    public Page<UserBookItem> selectUserListByPage(UserBookItemParam itemParam) {
        Page<UserBookItem> page = new Page<>(itemParam.getPageNum(), itemParam.getPageSize());
        return page.setRecords(this.baseMapper.selectUserBookItems(page, itemParam));
    }
}