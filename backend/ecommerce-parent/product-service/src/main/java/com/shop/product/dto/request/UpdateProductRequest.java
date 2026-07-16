package com.shop.product.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateProductRequest {

    @NotBlank
    @Size(max = 255)
    private String name;

    private String description;

    private String brand;

    private String category;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private Boolean active;
}