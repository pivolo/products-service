package com.mycomp.products.infrastructure.outbound.repositories.jpa;

import com.mycomp.products.domain.model.Product;
import com.mycomp.products.domain.repositories.ProductRepository;
import com.mycomp.products.infrastructure.outbound.repositories.jpa.dtos.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class ProductJPARepositoryImpl implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;
    private final ProductJpaMapper productJpaMapper;
    @Override
    public List<Product> findAll(String category, String sortField, String sortOrder) {
        ProductDto product = new ProductDto();
        product.setCategory(category);
        Example<ProductDto> filterExample = Example.of(product);
        Sort.Order order = "asc".equalsIgnoreCase(sortOrder)
                ? Sort.Order.asc(sortField)
                : Sort.Order.desc(sortField);
        List<ProductDto> productsDto = productJpaRepository.findAll(filterExample, Sort.by(order));
        return productJpaMapper.toDomain(productsDto);
    }
}
