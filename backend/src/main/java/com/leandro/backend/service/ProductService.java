package com.leandro.backend.service;

import org.springframework.stereotype.Service;

import com.leandro.backend.dto.ProductDTO;
import com.leandro.backend.entity.ProductEntity;
import com.leandro.backend.repository.IProductRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

/**
 * Service class for managing products.
 * This class contains business logic related to products and interacts with the product repository.
 *
 * @author Leandro Burgos
 * @version 0.1
 */
@Service
public class ProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Fetches all products.
     * @return a list of all products
     */
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Converts a ProductEntity to a ProductDTO.
     * @param product the ProductEntity to convert
     * @return the converted ProductDTO
     */
    private ProductDTO convertToDTO(ProductEntity product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNameProduct(product.getNameProduct());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setStock(product.getStock());
        productDTO.setCategoryId(product.getCategory().getId());
        return productDTO;
    }

    /**
     * Converts a ProductDTO to a ProductEntity.
     * @param id the ID of the product
     * @return the converted ProductEntity
     */
    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id).map(this::convertToDTO);
    }

    /**
     * Creates a new product.
     * @param productDTO the ProductDTO to create
     * @return the created ProductDTO
     */
    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductEntity product = convertToEntity(productDTO);
        ProductEntity savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    /**
     * converts a ProductDTO to a ProductEntity.
     * @param productDTO the ProductDTO to convert
     * @return the converted ProductEntity
     */
    private ProductEntity convertToEntity(ProductDTO productDTO) {
        ProductEntity product = new ProductEntity();
        product.setNameProduct(productDTO.getNameProduct());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        return product;
    }

    /**
     * Updates an existing product.
     * @param id the ID of the product to update
     * @param productDTO the updated ProductDTO
     * @return the updated ProductDTO, or an empty Optional if not found
     */
    public Optional<ProductDTO> updateProduct(Long id, ProductDTO productDTO) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setNameProduct(productDTO.getNameProduct());
                    existingProduct.setDescription(productDTO.getDescription());
                    existingProduct.setPrice(productDTO.getPrice());
                    existingProduct.setStock(productDTO.getStock());
                    ProductEntity updatedProduct = productRepository.save(existingProduct);
                    return convertToDTO(updatedProduct);
                });
    }

    /**
     * Deletes a product by its ID.
     * @param id the ID of the product to delete
     * @return true if the product was deleted, false if not found
     */
    public boolean deleteProduct(Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return true;
                })
                .orElse(false);
    }
}