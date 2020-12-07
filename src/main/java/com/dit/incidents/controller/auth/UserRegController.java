package com.dit.incidents.controller.auth;

import com.dit.incidents.external_request.auth.ExternalSignInRequest;
import com.dit.incidents.external_request.auth.ExternalSignUpRequest;
import com.dit.incidents.response.auth.SignInResponse;
import com.dit.incidents.response.generic.ApiResponse;
import com.dit.incidents.service.auth.UserRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/app")
public class UserRegController {

    @Autowired
    UserRegService userRegService;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody ExternalSignUpRequest externalSignUpRequest) {
        userRegService.signUpUser(externalSignUpRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Sign Up succeed"));
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody ExternalSignInRequest externalSignInRequest) {
        SignInResponse signInResponse = userRegService.signInUser(externalSignInRequest);
        return ResponseEntity.ok(signInResponse);
//        return ResponseEntity.ok(new ApiResponse(true, "Sign In succeed", signInResponse));
    }
}
