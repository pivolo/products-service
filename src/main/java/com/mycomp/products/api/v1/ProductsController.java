package com.mycomp.products.api.v1;

import com.mycomp.products.api.v1.model.ProductsGet200ResponseInner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductsController implements  ProductsApi{

    @Override
    public ResponseEntity<List<ProductsGet200ResponseInner>> productsGet() {
        var product = new ProductsGet200ResponseInner().category("cat").description("desc").sku("sku1")
                .discount(4F)
                .price(55.23F);
        return ResponseEntity.ok(List.of(product));

    }

}
