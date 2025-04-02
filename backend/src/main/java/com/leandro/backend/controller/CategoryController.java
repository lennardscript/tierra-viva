package com.leandro.backend.controller;

import com.leandro.backend.dto.CategoryDTO;
import com.leandro.backend.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CategoryController is a REST controller that handles requests related to categories.
 * It is part of the categories module of the Tierra Viva backend.
 *
 * @author Leandro Burgos
 * @version 0.1
 */
@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Fetches all categories.
     *
     * @return a list of all categories
     */
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }


    /**
     * Fetches a category by its ID.
     *
     * @param id the ID of the category to fetch
     * @return the category with the specified ID, or 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new category
     *
     * @param categoryDTO the category data to be created
     * @return the created category
     */
    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDTO categoryDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        CategoryDTO createdCategory = categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(201).body(createdCategory);
    }

    /**
     * Updates an existing category
     *
     * @param id          the ID of the category to update
     * @param categoryDTO the updated category data
     * @return the updated category, or 404 if not found
     */
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return categoryService.updateCategory(id, categoryDTO)
                .map(updatedCategory -> ResponseEntity.ok().body(updatedCategory))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Deletes a category by its ID
     *
     * @param id the ID of the category to delete
     * @return 204 No Content if deleted, or 404 if not found
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        if (categoryService.deleteCategory(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

