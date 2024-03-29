package com.dit.incidents.external_request.auth;

import com.sun.istack.NotNull;

public class ExternalSignInRequest {

    @NotNull
    private String username;

    @NotNull
    private String password;

    public ExternalSignInRequest() {
    }

    public ExternalSignInRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
