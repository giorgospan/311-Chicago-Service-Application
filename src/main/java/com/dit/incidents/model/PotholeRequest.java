package com.dit.incidents.model;

import javax.persistence.*;

@Entity
public class PotholeRequest{

    @Id
    private Long requestId;

    private String currentActivity;
    private String mostRecentAction;
    private Integer potholesFilled;
    private Integer ssa;

    @OneToOne
    @MapsId
    @JoinColumn(name="request_id")
    private Request request;

}
