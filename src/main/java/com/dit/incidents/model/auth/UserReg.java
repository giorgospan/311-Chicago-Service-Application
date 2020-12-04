package com.dit.incidents.model.auth;

import com.dit.incidents.external_request.auth.ExternalSignUpRequest;
import com.dit.incidents.model.log.Log;
import com.dit.incidents.model.request.Request;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "USER_REG")
public class UserReg {

    /*
     * Primary key is auto-generated, on insert
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_REG_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "USER_REG_ID", referencedColumnName = "USER_REG_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy="userReg", fetch = FetchType.LAZY)
    private Set<Request> requests;

    @OneToMany(mappedBy="userReg", fetch = FetchType.LAZY)
    private Set<Log> logs;

    public UserReg() {
    }

    public UserReg(String username) {
        this.username = username;
    }

    public UserReg(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserReg(ExternalSignUpRequest externalSignUpRequest) {
        this.username = externalSignUpRequest.getUsername();
        this.firstName = externalSignUpRequest.getFirstName();
        this.lastName = externalSignUpRequest.getLastName();
        this.email = externalSignUpRequest.getEmail();
    }

    public Long getId() {
        return id;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Log> getLogs() {
        return logs;
    }

    public void setLogs(Set<Log> logs) {
        this.logs = logs;
    }
}
