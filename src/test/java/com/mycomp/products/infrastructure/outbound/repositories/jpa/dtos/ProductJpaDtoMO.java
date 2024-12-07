package com.mycomp.products.infrastructure.outbound.repositories.jpa.dtos;

import java.util.List;

public class ProductJpaDtoMO {
    public static List<ProductDto> getProductsDto() {
        return List.of(
                new ProductDto("sku", 2.5F, "description", "cat"),
                new ProductDto("sku2", 2.6F, "description2", "cat2")
        );
    }

}