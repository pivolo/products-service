package com.mycomp.products.api.v1;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;

class ProductsControllerTest {
    private ProductsController productsController = new ProductsController();

    @Test
    void getProductsShouldReturnInfo(){
        assertThat(productsController.productsGet()).isNotNull();
    }



}