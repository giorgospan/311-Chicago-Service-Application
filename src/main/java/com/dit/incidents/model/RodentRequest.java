package com.dit.incidents.model;


import javax.persistence.*;

@Entity
public class RodentRequest{

    @Id
    private Long requestId;

    private String currentActivity;
    private String mostRecentAction;
    private Integer premisesBaited;
    private Integer premisesWithGarbage;
    private Integer premisesWithRats;

    @OneToOne
    @MapsId
    @JoinColumn(name="request_id")
    private Request request;

}
