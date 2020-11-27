package com.dit.incidents.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "requestId")
public class VehicleRequest extends Request{

    private String currentActivity;
    private String daysParked;
    private String licencePlate;
    private Short ssa;
    private String vehicleColor;
    private String vehicleModel;
}
