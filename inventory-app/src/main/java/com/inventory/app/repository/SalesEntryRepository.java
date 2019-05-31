package com.inventory.app.repository;

import com.inventory.app.model.SalesEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SalesEntryRepository extends CrudRepository<SalesEntry, Long> {
    Optional<List<SalesEntry>> findByProductId(String productId);
}
