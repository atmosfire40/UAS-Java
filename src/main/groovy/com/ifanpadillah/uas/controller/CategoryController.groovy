package com.ifanpadillah.uas.controller

import com.ifanpadillah.uas.entity.Category
import com.ifanpadillah.uas.service.CategoryService
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
@RequestMapping('/categories')
class CategoryController {
    @Autowired
    private CategoryService categoryService

    @GetMapping('')
    List<Category> findAll() {
        categoryService.findAll() as List<Category>
    }

    @GetMapping('{id}')
    Category findById(@PathVariable('id') int id) {
        categoryService.findById(id) as Category
    }

    @PostMapping()
    Category save(@RequestBody Category category) {
        categoryService.save(category)
    }

    @PutMapping('{id}')
    Category update(@RequestBody Category category, @PathVariable('id') int id) {
        categoryService.update(category, id)
    }

    @DeleteMapping('{id}')
    Category delete(@PathVariable('id') int id) {
        categoryService.delete(id)
    }
}
