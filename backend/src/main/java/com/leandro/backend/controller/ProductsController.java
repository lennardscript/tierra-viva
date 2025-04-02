package com.leandro.backend.controller;

import com.leandro.backend.dto.ProductDTO;
import com.leandro.backend.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ProductsController is a REST controller that handles requests related to
 * products.
 * It is part of the products module of the Tierra Viva backend.
 *
 * @author Leandro Burgos
 * @version 0.1
 */
@RestController
@RequestMapping("api/products")
public class ProductsController {

  private final ProductService productService;

  public ProductsController(ProductService productService) {
    this.productService = productService;
  }

  /**
   * Fetches all products.
   * 
   * @return a list of all products
   */
  @GetMapping
  public ResponseEntity<List<ProductDTO>> getAllProducts() {
    return ResponseEntity.ok(productService.getAllProducts());
  }

  /**
   * Fetches a product by its ID.
   * 
   * @param id the ID of the product to fetch
   * @return the product with the specified ID, or 404 if not found
   */
  @GetMapping("/{id}")
  public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
    return productService.getProductById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  /**
   * Creates a new product
   * 
   * @param productDTO the product data to be created
   * @return the created product
   */
  @PostMapping("/create")
  public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
    ProductDTO createdProduct = productService.createProduct(productDTO);
    return ResponseEntity.status(201).body(createdProduct);
  }

  /**
   * Updates an existing product
   * 
   * @param id         the ID of the product to update
   * @param productDTO the product data to be updated
   * @return the updated product
   */
  @PatchMapping("/update/{id}")
  public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
    return productService.updateProduct(id, productDTO)
        .map(updatedProduct -> ResponseEntity.ok().body(updatedProduct))
        .orElse(ResponseEntity.notFound().build());
  }

  /**
   * Deletes a product by its ID.
   * 
   * @param id the ID of the product to delete
   * @return 204 No Content if the product was deleted, or 404 if not found
   */
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    if (productService.deleteProduct(id)) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
