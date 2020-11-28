package com.dit.incidents.model;

import javax.persistence.*;

@Entity
public class SanitationRequest{

    @Id
    private Long requestId;

    private String nature;

    @OneToOne
    @MapsId
    @JoinColumn(name="request_id")
    private Request request;


}
