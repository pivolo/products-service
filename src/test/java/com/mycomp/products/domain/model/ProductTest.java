package com.mycomp.products.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    void productWithSkuEnding5ShouldReturnDiscountTest() {
        //Given
        Product product = ProductMO.productSku5();
        //When
        Float actualDiscount = product.getDiscount();
        //Then

        assertThat(actualDiscount).isEqualTo(30F);
    }

    @Test
    void productCategoryElectronicsShouldReturnDiscountTest() {
        //Given
        Product product = ProductMO.productElectronics();
        //When
        Float actualDiscount = product.getDiscount();
        //Then

        assertThat(actualDiscount).isEqualTo(15F);
    }


    @Test
    void productCategoryHomeShouldReturnDiscountTest() {
        //Given
        Product product = ProductMO.productHome();
        //When
        Float actualDiscount = product.getDiscount();
        //Then

        assertThat(actualDiscount).isEqualTo(25F);
    }
}