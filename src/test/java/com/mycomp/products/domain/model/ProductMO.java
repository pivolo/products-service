package com.mycomp.products.domain.model;

import java.util.List;

public class ProductMO {
    public static List<Product> productList(){
        return List.of(
                new Product("sku", 2.5F, "description", "cat", 5F),
                new Product("sku2", 2.6F, "description2", "cat2", 6F));
    }
}