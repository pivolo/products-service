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
    void getProductsReturnsRepositoryProductsTest() {
        //Given
        List<Product> products = ProductMO.productList();
        given(productRepository.findAll()).willReturn(products);
        //When
        List<Product> actualProducts = productUseCase.getProducts();
        //Then
        assertThat(actualProducts).hasSize(2).containsExactlyInAnyOrderElementsOf(products);
    }

}