package com.shop.product.service;

import com.shop.product.dto.request.CreateProductRequest;
import com.shop.product.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(CreateProductRequest request);

    ProductResponse getProduct(Long id);

    List<ProductResponse> getAllProducts();

    void deleteProduct(Long id);

}