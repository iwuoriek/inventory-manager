package com.inventory.app.repository;

import com.inventory.app.model.Sales;
import org.springframework.data.repository.CrudRepository;

public interface SalesRepository extends CrudRepository<Sales, String> {
}
