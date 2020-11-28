package com.dit.incidents.model;

import javax.persistence.*;

@Entity
public class TreeDebrisRequest{

    @Id
    private Long requestId;

    private String currentActivity;
    private String mostRecentAction;
    private String debrisLocation;

    @OneToOne
    @MapsId
    @JoinColumn(name="request_id")
    private Request request;

}
