package com.dit.incidents.response.auth;

public class SignInResponse {

    private Long id;

    private String jwt;

    private String username;

    private String email;

    private String firstName;

    private String lastName;


    public SignInResponse() {
    }

    public SignInResponse(Long id, String jwt, String username, String email, String firstName, String lastName) {
        this.id = id;
        this.jwt = jwt;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public SignInResponse(String jwt, String username, String email, String firstName, String lastName) {
        this.jwt = jwt;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
