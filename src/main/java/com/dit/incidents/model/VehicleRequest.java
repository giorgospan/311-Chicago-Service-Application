package com.dit.incidents.model;

import javax.persistence.*;

@Entity
public class VehicleRequest{

    @Id
    private Long requestId;

    private String currentActivity;
    private String recentAction;
    private String daysParked;
    private String licencePlate;
    private Integer ssa;
    private String vehicleColor;
    private String vehicleModel;

    @OneToOne
    @MapsId
    @JoinColumn(name="request_id")
    private Request request;

}
