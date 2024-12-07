package com.mycomp.products.infrastructure.outbound.repositories.jpa;

import com.mycomp.products.domain.model.Product;
import com.mycomp.products.infrastructure.outbound.repositories.jpa.dtos.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductJpaMapper {
    List<Product> toDomain(List<ProductDto> productDtos);
}
