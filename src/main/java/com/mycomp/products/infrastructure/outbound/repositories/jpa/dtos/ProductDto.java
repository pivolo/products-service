package com.mycomp.products.infrastructure.outbound.repositories.jpa.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "products")
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Setter
public class ProductDto {

    @Id
    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String category;
}
