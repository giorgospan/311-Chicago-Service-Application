package com.dit.incidents.repository.auth;

import com.dit.incidents.model.auth.UserReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegRepository extends JpaRepository<UserReg, Long> {
}
