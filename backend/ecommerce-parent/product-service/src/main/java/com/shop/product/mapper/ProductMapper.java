package com.shop.product.mapper;

import com.shop.product.dto.request.CreateProductRequest;
import com.shop.product.dto.response.ProductResponse;
import com.shop.product.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(CreateProductRequest request);

    ProductResponse toResponse(Product product);

}