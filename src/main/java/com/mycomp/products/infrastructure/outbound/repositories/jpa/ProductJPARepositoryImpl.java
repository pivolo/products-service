package com.mycomp.products.infrastructure.outbound.repositories.jpa;

import com.mycomp.products.domain.model.Product;
import com.mycomp.products.domain.repositories.ProductRepository;
import com.mycomp.products.infrastructure.outbound.repositories.jpa.dtos.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class ProductJPARepositoryImpl implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;
    private final ProductJpaMapper productJpaMapper;
    @Override
    public List<Product> findAll(String category) {
        ProductDto product = new ProductDto();
        product.setCategory(category);
        Example<ProductDto> filterExample = Example.of(product);
        List<ProductDto> productsDto = productJpaRepository.findAll(filterExample);
        return productJpaMapper.toDomain(productsDto);
    }
}
