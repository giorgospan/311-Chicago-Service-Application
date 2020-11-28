package com.dit.incidents.model;


import javax.persistence.*;

@Entity
public class TreeTrimRequest{

    @Id
    private Long requestId;

    private String treeLocation;

    @OneToOne
    @MapsId
    @JoinColumn(name="request_id")
    private Request request;


}
