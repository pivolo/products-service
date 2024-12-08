package com.mycomp.products.infrastructure.outbound.repositories.jpa;

import com.mycomp.products.domain.model.Product;
import com.mycomp.products.domain.repositories.ProductRepository;
import com.mycomp.products.infrastructure.outbound.repositories.jpa.dtos.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.util.StringUtils.hasText;

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
        Sort order;
        if (!hasText(sortField) || !hasText(sortOrder)){
            order = Sort.unsorted();
        }
        else{
            order = "asc".equalsIgnoreCase(sortOrder)
                ? Sort.by(Sort.Order.asc(sortField))
                : Sort.by(Sort.Order.desc(sortField));}
        List<ProductDto> productsDto = productJpaRepository.findAll(filterExample, order);
        return productJpaMapper.toDomain(productsDto);
    }
}
