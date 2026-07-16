package com.shop.product.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {

    private Long id;

    private String sku;

    private String name;

    private String description;

    private String brand;

    private String category;

    private BigDecimal price;

    private Boolean active;
}