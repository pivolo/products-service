package com.mycomp.products.infrastructure.outbound.repositories.jpa;

import com.mycomp.products.domain.model.Product;
import com.mycomp.products.domain.repositories.ProductRepository;
import com.mycomp.products.infrastructure.outbound.repositories.jpa.dtos.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class ProductJPARepositoryImpl implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;
    private final ProductJpaMapper productJpaMapper;
    @Override
    public List<Product> findAll() {
        List<ProductDto> productsDto = productJpaRepository.findAll();
        return productJpaMapper.toDomain(productsDto);
    }
}
