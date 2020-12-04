package com.dit.incidents.controller.auth;

import com.dit.incidents.repository.auth.UserRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegController {

    @Autowired
    UserRegRepository userRegRepository;



}
