package com.mycomp.products.infrastructure.inbound.rest.v1;

import com.mycomp.products.api.v1.ProductsApi;
import com.mycomp.products.api.v1.model.ProductsGet200ResponseInner;
import com.mycomp.products.application.ProductUseCase;
import com.mycomp.products.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductsApi {
    private final ProductUseCase productUseCase;
    private final ProductRestMapper productRestMapper;
    /**
     * REST controller for handling product-related requests.
     * Implements the ProductsApi interface to provide an endpoint for retrieving a list of products.
     * Utilizes ProductUseCase to fetch products based on category, sort field, and sort order.
     * Maps domain products to API response DTOs using ProductRestMapper.
     * Returns a 204 No Content response if no products are found, otherwise returns a 200 OK response with the product list.
     */
    @Override
    public ResponseEntity<List<ProductsGet200ResponseInner>> productsGet(String category, String sortField, String sortOrder) {
        List<Product> products = productUseCase.findProducts(category, sortField, sortOrder);

        return (products == null || products.isEmpty()) 
            ? ResponseEntity.noContent().build() 
            : ResponseEntity.ok(productRestMapper.toDtos(products));
    }


}
