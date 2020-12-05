package com.dit.incidents.model.request;


import javax.persistence.*;

@Entity
@Table(name = "LIGHTS_ONE_REQUEST")
public class LightsOneRequest{

    @Id
    @Column(name = "LIGHTS_ONE_ID")
    private Long id;

    //@OneToOne(fetch = FetchType.LAZY)
    @OneToOne
    @MapsId
    @JoinColumn(name="REQUEST_ID")
    private Request request;

    public LightsOneRequest() {
    }

    public LightsOneRequest(Long id, Request request) {
        this.id = id;
        this.request = request;
    }

    public LightsOneRequest(Request request) {
        this.request = request;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
