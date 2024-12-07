package com.mycomp.products.infrastructure.inbound.rest.v1;
import com.mycomp.products.api.v1.model.ProductsGet200ResponseInner;
import com.mycomp.products.application.ProductUseCase;
import com.mycomp.products.domain.model.ProductMO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
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
    @Test
    void findShouldReturnOk() {
        // Given
        String category = "cat";
        given(productUseCase.findProducts(category)).willReturn(ProductMO.productList());
        // When
        ResponseEntity<List<ProductsGet200ResponseInner>> actual = productController.productsGet(category, null, null);
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


}