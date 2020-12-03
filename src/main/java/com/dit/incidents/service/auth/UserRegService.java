package com.dit.incidents.service.auth;

import com.dit.incidents.repository.auth.UserRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegService {

    @Autowired
    private UserRegRepository userRegRepository;

}
