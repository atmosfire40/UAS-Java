package com.ifanpadillah.uas.service.impl

import com.ifanpadillah.uas.entity.Category
import com.ifanpadillah.uas.repository.CategoryRepository
import com.ifanpadillah.uas.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository

    @Override
    List<Category> findAll() {
        categoryRepository.findAll() as List<Category>
    }

    @Override
    Category findById(int id) {
        categoryRepository.findById(id)
    }

    @Override
    Category save(Category category) {
        categoryRepository.save(category)
    }

    @Override
    Category update(Category category, int id) {
        def record = categoryRepository.findById(id)
        record.with {
            name = category.name
        }
        categoryRepository.save(record)
        record
    }

    @Override
    Category delete(int id) {
        def record = categoryRepository.findById(id)
        categoryRepository.delete(record)
        record
    }
}
