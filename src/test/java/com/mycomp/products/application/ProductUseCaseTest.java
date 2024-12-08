package com.mycomp.products.application;

import com.mycomp.products.domain.model.Product;
import com.mycomp.products.domain.model.ProductMO;
import com.mycomp.products.domain.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProductUseCaseTest {
    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductUseCase productUseCase;

    @Test
    void findProductsReturnsRepositoryProductsTest() {
        //Given
        List<Product> products = ProductMO.productList();
        String category = "cat";
        String sortField = "price";
        String sortOrder = "desc";
        given(productRepository.findAll(category, sortField, sortOrder)).willReturn(products);
        //When
        List<Product> actualProducts = productUseCase.findProducts(category, sortField, sortOrder);
        //Then
        assertThat(actualProducts).hasSize(2).containsExactlyInAnyOrderElementsOf(products);
    }

}