package com.mycomp.products.infrastructure.outbound.repositories.jpa;

import com.mycomp.products.infrastructure.outbound.repositories.jpa.dtos.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductDto, String> {
}
