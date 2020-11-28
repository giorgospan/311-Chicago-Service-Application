package com.dit.incidents.model.request;

import javax.persistence.*;

@Entity(name = "SANITATION_REQUEST")
public class SanitationRequest{

    @Id
    @Column(name = "SANITATION_ID")
    private Long id;

    private String nature;

    @OneToOne
    @MapsId
    @JoinColumn(name="REQUEST_ID")
    private Request request;

    public SanitationRequest(Long id, String nature, Request request) {
        this.id = id;
        this.nature = nature;
        this.request = request;
    }

    public SanitationRequest(String nature, Request request) {
        this.nature = nature;
        this.request = request;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}