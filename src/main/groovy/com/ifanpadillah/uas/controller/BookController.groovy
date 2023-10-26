package com.ifanpadillah.uas.controller

import com.ifanpadillah.uas.entity.Book
import com.ifanpadillah.uas.entity.Category
import com.ifanpadillah.uas.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/books')
class BookController {
    @Autowired
    private BookService bookService

    @GetMapping('')
    List<Book> findAll() {
        bookService.findAll() as List<Book>
    }

    @GetMapping('{id}')
    Book findById(@PathVariable('id') int id) {
        bookService.findById(id) as Book
    }

    @PostMapping()
    Book save(@RequestBody Map<String, Object> bookRequest) {
        bookService.save(bookRequest)
    }

    @PutMapping('{id}')
    Book update(@RequestBody Map<String, Object> bookRequest, @PathVariable('id') int id) {
        bookService.update(bookRequest, id)
    }

    @DeleteMapping('{id}')
    Book delete(@PathVariable('id') int id) {
        bookService.delete(id)
    }
}