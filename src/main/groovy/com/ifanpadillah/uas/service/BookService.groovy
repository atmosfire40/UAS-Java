package com.ifanpadillah.uas.service

import com.ifanpadillah.uas.entity.Book

interface BookService {
    List<Book> findAll()
    Book findById(int id)
    Book save(Map<String, Object> bookRequest)
    Book update(Map<String, Object> bookRequest, int id)
    Book delete(int id)
}
