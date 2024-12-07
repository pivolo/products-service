package com.mycomp.products.infrastructure.inbound.rest.v1;

import com.mycomp.products.api.v1.model.ProductsGet200ResponseInner;
import com.mycomp.products.domain.model.ProductMO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductRestMapperTest {
    ProductRestMapper productRestMapper = new ProductRestMapperImpl();
    @Test
    void shouldMapToDto(){
        //given
        var products = ProductMO.productList();
        var firstProduct = products.get(0);
        //when
        var actual = productRestMapper.toDtos(products);
        assertThat(actual).hasSize(2);
        assertThat(actual.get(0))
                .returns(firstProduct.category(), ProductsGet200ResponseInner::getCategory);
    }
}