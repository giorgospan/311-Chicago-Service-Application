package com.dit.incidents.model.auth;

import com.dit.incidents.enums.RoleName;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NAME")
    //@NaturalId
    private RoleName name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<UserReg>  userRegList = new HashSet<>();

    public Role() {
    }

    public Role(RoleName name) {
        this.name = name;
    }

    public Role(RoleName name, Set<UserReg> userRegList) {
        this.name = name;
        this.userRegList = userRegList;
    }

    public Long getId() {
        return id;
    }

    public RoleName getName() {
        return name;
    }

    public void setRole(RoleName name) {
        this.name = name;
    }

    public Set<UserReg> getUserRegList() {
        return userRegList;
    }

    public void setUserRegList(Set<UserReg> userRegList) {
        this.userRegList = userRegList;
    }
}
