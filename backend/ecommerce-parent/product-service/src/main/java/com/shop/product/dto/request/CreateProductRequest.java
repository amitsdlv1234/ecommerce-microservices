package com.shop.product.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductRequest {

    @NotBlank(message = "SKU is required")
    @Size(max = 50)
    private String sku;

    @NotBlank(message = "Product name is required")
    @Size(max = 255)
    private String name;

    private String description;

    @Size(max = 150)
    private String brand;

    @Size(max = 150)
    private String category;

    @NotNull
    @Positive
    private BigDecimal price;
}