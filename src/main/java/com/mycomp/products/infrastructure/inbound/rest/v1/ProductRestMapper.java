package com.mycomp.products.infrastructure.inbound.rest.v1;

import com.mycomp.products.api.v1.model.ProductsGet200ResponseInner;
import com.mycomp.products.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductRestMapper {
    List<ProductsGet200ResponseInner> toDtos(List<Product> product);
}
