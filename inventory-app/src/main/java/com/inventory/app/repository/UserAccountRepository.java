package com.inventory.app.repository;

import com.inventory.app.model.Business;
import com.inventory.app.model.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    Optional<UserAccount> findByUsername(String username);

    Optional<List<UserAccount>> findByBusiness(Business business);
}
