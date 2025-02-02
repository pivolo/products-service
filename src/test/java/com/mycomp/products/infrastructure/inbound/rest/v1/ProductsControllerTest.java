package com.mycomp.products.infrastructure.inbound.rest.v1;

import com.mycomp.products.api.v1.model.ProductsGet200ResponseInner;
import com.mycomp.products.application.ProductUseCase;
import com.mycomp.products.domain.model.Product;
import com.mycomp.products.domain.model.ProductMO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @Mock
    private ProductUseCase productUseCase;

    private final ProductRestMapper productRestMapper = new ProductRestMapperImpl();

    private ProductController productController;


    @BeforeEach
    public void beforeEach() {
        productController = new ProductController(productUseCase, productRestMapper);
    }

    @ParameterizedTest
    @CsvSource({
            "cat, price, desc",
            "cat2, name, asc",
            "cat3, rating, desc"
    })
    void findShouldReturnOk(String category, String sortField, String sortOrder) {
        // Given
        given(productUseCase.findProducts(category, sortField, sortOrder)).willReturn(ProductMO.productList());
        // When
        ResponseEntity<List<ProductsGet200ResponseInner>> actual = productController.productsGet(category, sortField, sortOrder);
        // Then
        assertThat(actual).isNotNull()
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.OK);
        assertThat(actual).isNotNull()
                .extracting(ResponseEntity::getBody)
                .asInstanceOf(LIST)
                .hasSize(2)
                .first().isInstanceOf(ProductsGet200ResponseInner.class);
    }

    // Returns no content when the product list is null
    @Test
    public void returnsNoContentForNullProducts() {
        // Given
        String category = "Electronics";
        String sortField = "price";
        String sortOrder = "asc";

        given(productUseCase.findProducts(category, sortField, sortOrder)).willReturn(null);

        // When
        ResponseEntity<List<ProductsGet200ResponseInner>> response = productController.productsGet(category, sortField, sortOrder);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        assertThat(response.getBody()).isNull();
        then(productUseCase).should().findProducts(category, sortField, sortOrder);
    }

    // Throws RuntimeException when ProductUseCase throws an exception
    @Test
    public void testProductsGetThrowsRuntimeException() {
        // Given
        ProductController controller = new ProductController(productUseCase, productRestMapper);

        given(productUseCase.findProducts("Electronics", "price", "asc"))
                .willThrow(new RuntimeException("Database error"));

        // When & Then
        assertThatThrownBy(() -> controller.productsGet("Electronics", "price", "asc"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Database error");
    }


}