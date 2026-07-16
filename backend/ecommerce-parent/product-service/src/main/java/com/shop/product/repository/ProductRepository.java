package com.shop.product.repository;

import com.shop.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findBySku(String sku);

    boolean existsBySku(String sku);

    List<Product> findByCategory(String category);

    List<Product> findByBrand(String brand);

    List<Product> findByPriceBetween(
            BigDecimal min,
            BigDecimal max);

    List<Product> findByActiveTrue();

    List<Product> findByNameContainingIgnoreCase(
            String keyword);

    Page<Product> findAll(Pageable pageable);
}