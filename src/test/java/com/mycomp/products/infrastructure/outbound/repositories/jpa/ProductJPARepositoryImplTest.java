package com.mycomp.products.infrastructure.outbound.repositories.jpa;

import com.mycomp.products.domain.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ProductJPARepositoryImplTest {
    @Mock ProductJpaRepository jpaRepository;

    @InjectMocks ProductJPARepositoryImpl productRepository;

    @Test
    void findAllReturnsAllProductsFromRepositoryTest() {
        //Given

        //When
        List<Product> products =productRepository.findAll();
        //Then
        assertThat(products).isEmpty();
    }

}