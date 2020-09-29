package com.liuxun.service.serviceImpl;

import com.liuxun.domain.Book;
import com.liuxun.domain.User;
import com.liuxun.service.BookService;
import com.liuxun.service.TractionService;
import com.liuxun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
public class TractionServiceImpl implements TractionService {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Override
    public Map<String, Object> insert(Book book, User user) {
        HashMap<String, Object> resultMap = new HashMap<>();
        bookService.save(book);
        resultMap.put("book", book);
        userService.save(user);
        resultMap.put("user", user);
        return resultMap;
    }
}
