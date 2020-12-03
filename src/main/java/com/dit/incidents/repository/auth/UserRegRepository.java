package com.dit.incidents.repository.auth;

import com.dit.incidents.model.auth.UserReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRegRepository extends JpaRepository<UserReg, Long> {

    Optional<UserReg> findUserRegByUsername(String username);

}
