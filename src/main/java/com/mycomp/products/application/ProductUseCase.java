package com.mycomp.products.application;

import com.mycomp.products.domain.model.Product;
import com.mycomp.products.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductUseCase {
    private final ProductRepository productRepository;
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
