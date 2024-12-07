package com.mycomp.products.infrastructure.outbound.repositories.jpa;

import com.mycomp.products.domain.model.Product;
import com.mycomp.products.infrastructure.outbound.repositories.jpa.dtos.ProductDto;
import com.mycomp.products.infrastructure.outbound.repositories.jpa.dtos.ProductJpaDtoMO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProductJPARepositoryImplTest {
    @Mock
    private ProductJpaRepository jpaRepository;
    private final ProductJpaMapper productJpaMapper = new ProductJpaMapperImpl();
    private ProductJPARepositoryImpl productRepository;

    @BeforeEach
    void beforeEach() {
        productRepository = new ProductJPARepositoryImpl(jpaRepository, productJpaMapper);
    }

    @Test
    void findAllReturnsAllProductsFromRepositoryTest() {
        //Given

        String category = "cat";
        ProductDto product = new ProductDto();
        product.setCategory(category);
        Example<ProductDto> filterExample = Example.of(product);
        given(jpaRepository.findAll(filterExample)).willReturn(ProductJpaDtoMO.getProductsDto());
        //When
        List<Product> products = productRepository.findAll(category);
        //Then
        assertThat(products).hasSize(2);
    }

}