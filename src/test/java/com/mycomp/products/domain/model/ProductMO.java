package com.mycomp.products.domain.model;

import java.util.List;

public class ProductMO {
    public static List<Product> productList(){
        return List.of(
                new Product("sku", 2.5F, "description", "cat"),
                new Product("sku2", 2.6F, "description2", "cat2"));
    }

    public static Product productSku5() {
        return new Product("sku005", 2.5F, "description", "cat");
    }
    public static Product productElectronics() {
        return new Product("sku007", 2.5F, "description", "Electronics");
    }
    public static Product productHome() {
        return new Product("sku008", 245F, "description", "Home & Kitchen");
    }
    //
}