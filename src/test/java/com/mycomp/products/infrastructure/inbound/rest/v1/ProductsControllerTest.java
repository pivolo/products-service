package com.mycomp.products.infrastructure.inbound.rest.v1;
import com.mycomp.products.api.v1.model.ProductsGet200ResponseInner;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;

class ProductsControllerTest {
    private final ProductsController productsController = new ProductsController();

    @Test
    void getProductsShouldReturnOk(){
        assertThat(productsController.productsGet()).isNotNull()
                .extracting(ResponseEntity::getStatusCode)
                .isEqualTo(HttpStatus.OK);
        assertThat(productsController.productsGet()).isNotNull()
                .extracting(ResponseEntity::getBody)
                .asInstanceOf(LIST)
                .hasSize(1)
                .first().isInstanceOf(ProductsGet200ResponseInner.class);
    }



}