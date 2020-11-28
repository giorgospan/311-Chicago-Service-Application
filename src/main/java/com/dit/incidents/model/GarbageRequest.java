package com.dit.incidents.model;

import javax.persistence.*;

@Entity
public class GarbageRequest{

    @Id
    private Long requestId;

    private String currentActivity;
    private String mostRecentAction;
    private Long numOfBlackCarts;
    private Integer ssa;

    @OneToOne
	@MapsId
	@JoinColumn(name="request_id")
    private Request request;
}



