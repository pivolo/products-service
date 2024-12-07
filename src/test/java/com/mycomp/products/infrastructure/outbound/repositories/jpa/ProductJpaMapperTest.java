package com.mycomp.products.infrastructure.outbound.repositories.jpa;

import com.mycomp.products.domain.model.Product;
import com.mycomp.products.infrastructure.outbound.repositories.jpa.dtos.ProductDto;
import com.mycomp.products.infrastructure.outbound.repositories.jpa.dtos.ProductDtoMO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductJpaMapperTest {

private final ProductJpaMapper productJpaMapper = new ProductJpaMapperImpl();
    @Test
    void toDomainShouldMapDtosTest() {
        //Given
        List<ProductDto> productsDto = ProductDtoMO.getProductsDto();
        //When
        List<Product> actualProducts = productJpaMapper.toDomain(productsDto);
        //Then
        assertThat(actualProducts).hasSize(2);
    }
}