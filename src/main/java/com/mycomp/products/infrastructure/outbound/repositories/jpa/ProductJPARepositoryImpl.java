package com.mycomp.products.infrastructure.outbound.repositories.jpa;

import com.mycomp.products.domain.model.Product;
import com.mycomp.products.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class ProductJPARepositoryImpl implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;
    @Override
    public List<Product> findAll() {
        return List.of();
    }
}
