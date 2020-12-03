package com.dit.incidents.security;

import com.dit.incidents.model.auth.UserReg;
import com.dit.incidents.repository.auth.UserRegRepository;
import com.dit.incidents.service.auth.UserRegService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/*
 * This class loads a user’s data given its username.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRegRepository userRegRepository;

    /*
     * When a user tries to authenticate, this method receives the username,
     * searches the database for a record containing it
     * and (if found) returns an instance of User
     * otherwise an exception is thrown.
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserReg user = userRegRepository.findUserRegByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username: \"" + username + "\" was not found.")
                );

        return UserDetailsImpl.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        UserReg user = userRegRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User with id: \"" + id + "\" was not found.")
                );

        return UserDetailsImpl.create(user);
    }
}