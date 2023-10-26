package com.ifanpadillah.uas.service.impl

import com.ifanpadillah.uas.entity.Book
import com.ifanpadillah.uas.entity.Category
import com.ifanpadillah.uas.repository.BookRepository
import com.ifanpadillah.uas.repository.CategoryRepository
import com.ifanpadillah.uas.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository

    @Autowired
    private CategoryRepository categoryRepository

    @Override
    List<Book> findAll() {
        bookRepository.findAll() as List<Book>
    }

    @Override
    Book findById(int id) {
        bookRepository.findById(id)
    }

    @Override
    Book save(Map<String, Object> bookRequest) {
        Integer categoryId = bookRequest.get("category_id") as Integer
        Category category = categoryRepository.findById(categoryId) as Category

        if (category != null) {
            Book book = new Book(
                    name: bookRequest.get("name"),
                    isbn: bookRequest.get("isbn"),
                    category: category
            )
            return bookRepository.save(book)
        }
    }

    @Override
    Book update(Map<String, Object> bookRequest, int id) {
        Book book = bookRepository.findById(id)

        Integer categoryId = bookRequest.get("category_id") as Integer
        Category category = categoryRepository.findById(categoryId) as Category

        if (category != null) {
            book.name = bookRequest.get("name")
            book.isbn = bookRequest.get("isbn")
            book.category = category
            bookRepository.save(book)
            return book
        }
    }

    @Override
    Book delete(int id) {
        def record = bookRepository.findById(id)
        bookRepository.delete(record)
        record
    }
}