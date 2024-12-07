package com.mycomp.products.infrastructure.inbound.rest.v1;

import com.mycomp.products.api.v1.ProductsApi;
import com.mycomp.products.api.v1.model.ProductsGet200ResponseInner;
import com.mycomp.products.application.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductsApi {
    private final ProductUseCase productUseCase;
    private final ProductMapper productMapper;

    @Override
    public ResponseEntity<List<ProductsGet200ResponseInner>> productsGet() {
        var products = productUseCase.getProducts();
        return ResponseEntity.ok(productMapper.toDtos(products));

    }

}
