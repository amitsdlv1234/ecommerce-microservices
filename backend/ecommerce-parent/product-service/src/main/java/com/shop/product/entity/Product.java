package com.shop.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        name = "products",
        indexes = {
                @Index(name = "idx_product_name", columnList = "name"),
                @Index(name = "idx_product_category", columnList = "category"),
                @Index(name = "idx_product_brand", columnList = "brand")
        }
)
public class Product extends BaseEntity {

    @NotBlank
    @Column(nullable = false, unique = true, length = 50)
    private String sku;

    @NotBlank
    @Column(nullable = false, length = 255)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 150)
    private String brand;

    @Column(length = 150)
    private String category;

    @NotNull
    @Digits(integer = 13, fraction = 2)
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal price;

    @Builder.Default
    @Column(nullable = false)
    private Boolean active = true;
}