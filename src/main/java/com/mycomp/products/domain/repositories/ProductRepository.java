package com.mycomp.products.domain.repositories;

import com.mycomp.products.domain.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll(String category, String sortField, String sortOrder);
}
