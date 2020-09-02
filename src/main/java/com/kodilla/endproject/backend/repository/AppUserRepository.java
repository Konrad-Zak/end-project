package com.kodilla.endproject.backend.repository;

import com.kodilla.endproject.backend.domian.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {



    AppUser findByUsername(String username);

}
