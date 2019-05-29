package com.inventory.app.repository;

import com.inventory.app.model.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Long> {
}
