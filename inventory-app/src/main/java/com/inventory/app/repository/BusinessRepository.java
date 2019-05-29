package com.inventory.app.repository;

import com.inventory.app.model.Business;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BusinessRepository extends CrudRepository<Business, Long> {
    Optional<Business> findByReference(String reference);

    Optional<Business> findByEmail(String email);
}
