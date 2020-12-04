package com.dit.incidents.repository.auth;

import com.dit.incidents.model.auth.UserReg;
import org.h2.engine.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRegRepository extends JpaRepository<UserReg, Long> {

    Optional<UserReg> findByUsername(String username);

    Optional<UserReg> findByEmail(String email);

}
