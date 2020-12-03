package com.dit.incidents.service.auth;

import com.dit.incidents.enums.RoleName;
import com.dit.incidents.model.auth.Role;
import com.dit.incidents.repository.auth.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createDefaultRole() {
        Role searchedRole = roleRepository.findRoleByName(RoleName.BASIC_ROLE).orElse(null);
        if (searchedRole != null) return searchedRole;
        return roleRepository.save(new Role(RoleName.BASIC_ROLE));
    }

}
