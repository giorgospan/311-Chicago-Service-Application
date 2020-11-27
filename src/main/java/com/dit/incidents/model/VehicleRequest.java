package com.dit.incidents.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "requestId")
public class VehicleRequest extends Request{

    @Column(length=400)
    private String currentActivity;

    @Column(length=400)
    private String recentAction;
    private String daysParked;

    @Column(length=400)
    private String licencePlate;
    private Short ssa;
    private String vehicleColor;
    private String vehicleModel;
}
