package com.ifanpadillah.uas.repository

import com.ifanpadillah.uas.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository extends JpaRepository<Book, Integer>{
    List<Book> findAll()
    Book findById(int id)
    Book save(Book book)
    void delete(Book book)
}
