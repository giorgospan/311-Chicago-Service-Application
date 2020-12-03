package com.dit.incidents;

import com.dit.incidents.model.auth.Role;
import com.dit.incidents.repository.auth.RoleRepository;
import com.dit.incidents.repository.request.RequestRepository;
import com.dit.incidents.service.auth.RoleService;
import com.dit.incidents.service.auth.UserRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class ChicagoIncidentsApplication implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRegService userRegService;

    public static void main(String[] args) {
        SpringApplication.run(ChicagoIncidentsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // insert simple role
        Role defaultRole = roleService.createDefaultRole();
        userRegService.createDefaultUser(defaultRole);
    }
}
