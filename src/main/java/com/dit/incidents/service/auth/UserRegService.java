package com.dit.incidents.service.auth;

import com.dit.incidents.model.auth.Role;
import com.dit.incidents.model.auth.UserReg;
import com.dit.incidents.repository.auth.UserRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserRegService {

    @Autowired
    private UserRegRepository userRegRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;


    public void createDefaultUser(Role role) {
        UserReg userReg = userRegRepository.findUserRegByUsername("User1").orElse(null);
        if (userReg != null) return;
        userReg = new UserReg();
        userReg.setRoles(new HashSet<>(){{add(role);}});
        userReg.setUsername("User1");
        userReg.setPassword("pass");
        userRegRepository.save(userReg);
    }

}
