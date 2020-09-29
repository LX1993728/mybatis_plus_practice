package com.liuxun.controllers;

import com.liuxun.domain.Book;
import com.liuxun.domain.User;
import com.liuxun.service.TractionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 测试多数据源的事务
 */
@Slf4j
@RequestMapping("/traction")
@RestController
public class MultiController {

    @Autowired
    private TractionService tractionService;

    @GetMapping("/insert")
    public Object insert(){
        long flag = System.currentTimeMillis();
        Book book = new Book();
        book.setAuthor("author_" + flag);
        book.setBookName("bookName_" + flag);

        User user = new User();
        user.setNickname("nickName_" + flag);
        user.setLoginName("loginName_" + flag);
        final Map<String, Object> objectMap = tractionService.insert(book, user);
        return objectMap;
    }
}
