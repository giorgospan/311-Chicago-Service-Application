package com.dit.incidents.service.auth;

import com.dit.incidents.enums.RoleName;
import com.dit.incidents.exception.AppException;
import com.dit.incidents.exception.UserExistsException;
import com.dit.incidents.external_request.auth.ExternalSignInRequest;
import com.dit.incidents.external_request.auth.ExternalSignUpRequest;
import com.dit.incidents.model.auth.Role;
import com.dit.incidents.model.auth.UserReg;
import com.dit.incidents.repository.auth.UserRegRepository;
import com.dit.incidents.response.auth.SignInResponse;
import com.dit.incidents.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserRegService {

    @Autowired
    private UserRegRepository userRegRepository;

    @Autowired
    private RoleService roleService;


    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void createDefaultUser(Role role) {
        UserReg userReg = userRegRepository.findByUsername("User1").orElse(null);
        if (userReg != null) return;
        userReg = new UserReg();
        userReg.setRoles(new HashSet<>(){{add(role);}});
        userReg.setUsername("User1");
        userReg.setPassword(passwordEncoder.encode("pass"));
        userRegRepository.save(userReg);
    }

    public void signUpUser(ExternalSignUpRequest externalSignUpRequest) {
        userRegRepository.findByUsername(externalSignUpRequest.getUsername())
                .ifPresent((s) -> {
                    throw new UserExistsException("A user with the same username already exists");
                });

        userRegRepository.findByEmail(externalSignUpRequest.getEmail())
                .ifPresent((s) -> {
                    throw new UserExistsException("A user with the same email already exists");
                });

        UserReg userReg = new UserReg(externalSignUpRequest);

        userReg.setPassword(passwordEncoder.encode(userReg.getPassword()));

        Role role = roleService.findByName(RoleName.BASIC_ROLE)
                .orElseThrow(() -> new AppException("Basic Role not found"));
        userReg.setRoles(new HashSet<>(){{add(role);}});
    }

        public SignInResponse signInUser(ExternalSignInRequest externalSignInRequest) {
        // Check if the user exists
        UserReg userReg = userRegRepository.findByUsername(externalSignInRequest.getUsername()).
                orElseThrow(() -> new AppException("Invalid username or password"));

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        externalSignInRequest.getUsername(),
                        externalSignInRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);

        return new SignInResponse(jwt, userReg.getUsername(), userReg.getEmail(), userReg.getFirstName(), userReg.getLastName());
    }

}
