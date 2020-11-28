package com.dit.incidents.model.auth;

import com.dit.incidents.enums.RoleName;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "ROLE")
public class Role {

    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ROLE_NAME")
    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName role;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<UserReg>  userRegList = new HashSet<>();

    public Role() {
    }

    public Role(RoleName role, Set<UserReg> userRegList) {
        this.role = role;
        this.userRegList = userRegList;
    }

    public Long getId() {
        return id;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

    public Set<UserReg> getUserRegList() {
        return userRegList;
    }

    public void setUserRegList(Set<UserReg> userRegList) {
        this.userRegList = userRegList;
    }
}
