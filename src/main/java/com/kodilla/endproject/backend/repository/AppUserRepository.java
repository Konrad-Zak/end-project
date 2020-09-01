package com.kodilla.endproject.backend.repository;

import com.kodilla.endproject.backend.domian.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
