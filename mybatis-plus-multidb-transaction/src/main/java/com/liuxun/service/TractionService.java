package com.liuxun.service;

import com.liuxun.domain.Book;
import com.liuxun.domain.User;

import java.util.Map;

public interface TractionService {
    Map<String, Object> insert(Book book, User user);
}
