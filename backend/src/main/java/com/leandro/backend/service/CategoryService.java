package com.leandro.backend.service;

import org.springframework.stereotype.Service;

import com.leandro.backend.dto.CategoryDTO;
import com.leandro.backend.entity.CategoryEntity;
import com.leandro.backend.repository.ICategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class for managing categories.
 * This class contains business logic related to categories and interacts with the category repository.
 *
 * @author Leandro Burgos
 * @version 0.1
 */
@Service
public class CategoryService {

    private final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Fetches all categories.
     *
     * @return a list of all categories
     */
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Converts a CategoryEntity to a CategoryDTO.
     *
     * @param category the CategoryEntity to convert
     * @return the converted CategoryDTO
     */
    private CategoryDTO convertToDTO(CategoryEntity category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setNameCategory(category.getNameCategory());
        return categoryDTO;
    }

    /**
     * Converts a CategoryDTO to a CategoryEntity.
     * @param categoryDTO the CategoryDTO to convert
     * @return the converted CategoryEntity
     */
    private CategoryEntity convertToEntity(CategoryDTO categoryDTO) {
        CategoryEntity category = new CategoryEntity();
        category.setNameCategory(categoryDTO.getNameCategory());
        return category;
    }

    /**
     * Fetches a category by its ID.
     * @param id the ID of the category to fetch
     * @return the category with the specified ID, or an empty Optional if not found
     */
    public Optional<CategoryDTO> getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(this::convertToDTO);
    }

    /**
     * Creates a new category.
     * @param categoryDTO the category data to be created
     * @return the created category
     */
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        CategoryEntity category = convertToEntity(categoryDTO);
        CategoryEntity savedCategory = categoryRepository.save(category);
        return convertToDTO(savedCategory);
    }

    /**
     * Updates an existing category.
     * @param id the ID of the category to update
     * @param categoryDTO the updated category data
     * @return the updated category, or an empty Optional if not found
     */
    public Optional<CategoryDTO> updateCategory(Long id, CategoryDTO categoryDTO) {
        return categoryRepository.findById(id)
                .map(existingCategory -> {
                    existingCategory.setNameCategory(categoryDTO.getNameCategory());
                    CategoryEntity updatedCategory = categoryRepository.save(existingCategory);
                    return convertToDTO(updatedCategory);
                });
    }

    /**
     * Deletes a category by its ID.
     * @param id the ID of the category to delete
     * @return true if the category was deleted, false if not found
     */
    public boolean deleteCategory(Long id) {
        return categoryRepository.findById(id)
                .map(category -> {
                    categoryRepository.delete(category);
                    return true;
                })
                .orElse(false);
    }
}