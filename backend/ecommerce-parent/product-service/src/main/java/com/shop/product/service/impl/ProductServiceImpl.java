package com.shop.product.service.impl;

import com.shop.product.dto.request.CreateProductRequest;
import com.shop.product.dto.response.ProductResponse;
import com.shop.product.entity.Product;
import com.shop.product.exception.DuplicateSkuException;
import com.shop.product.exception.ProductNotFoundException;
import com.shop.product.mapper.ProductMapper;
import com.shop.product.repository.ProductRepository;
import com.shop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {

        log.info("Creating product with SKU: {}", request.getSku());

        if (repository.existsBySku(request.getSku())) {
            throw new DuplicateSkuException(request.getSku());
        }

        Product product = mapper.toEntity(request);

        Product savedProduct = repository.save(product);

        log.info("Product created successfully. ID={}", savedProduct.getId());

        return mapper.toResponse(savedProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse getProduct(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(id));

        return mapper.toResponse(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public void deleteProduct(Long id) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException(
                    "Product not found : " + id);
        }

        repository.deleteById(id);

        log.info("Product deleted. ID={}", id);
    }
}