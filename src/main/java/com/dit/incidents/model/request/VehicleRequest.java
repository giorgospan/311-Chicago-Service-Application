package com.dit.incidents.model.request;

import javax.persistence.*;

@Entity
public class VehicleRequest{

    @Id
    @Column(name = "REQUEST_ID")
    private Long requestId;

    @Column(name = "CURRENT_ACTIVITY")
    private String currentActivity;

    @Column(name = "RECENT_ACTION")
    private String recentAction;

    @Column(name = "DAYS_PARKED")
    private String daysParked;

    @Column(name = "LICENCE_PLATE")
    private String licencePlate;

    @Column(name = "SSA")
    private Integer ssa;

    @Column(name = "VEHICLE_COLOR")
    private String vehicleColor;

    @Column(name = "VEHICLE_MODEL")
    private String vehicleModel;

    @OneToOne
    @MapsId
    @JoinColumn(name = "REQUEST_ID")
    private Request request;

    public VehicleRequest() {
    }

    public VehicleRequest(Long requestId, String currentActivity, String recentAction, String daysParked, String licencePlate, Integer ssa, String vehicleColor, String vehicleModel, Request request) {
        this.requestId = requestId;
        this.currentActivity = currentActivity;
        this.recentAction = recentAction;
        this.daysParked = daysParked;
        this.licencePlate = licencePlate;
        this.ssa = ssa;
        this.vehicleColor = vehicleColor;
        this.vehicleModel = vehicleModel;
        this.request = request;
    }

    public VehicleRequest(String currentActivity, String recentAction, String daysParked, String licencePlate, Integer ssa, String vehicleColor, String vehicleModel, Request request) {
        this.currentActivity = currentActivity;
        this.recentAction = recentAction;
        this.daysParked = daysParked;
        this.licencePlate = licencePlate;
        this.ssa = ssa;
        this.vehicleColor = vehicleColor;
        this.vehicleModel = vehicleModel;
        this.request = request;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(String currentActivity) {
        this.currentActivity = currentActivity;
    }

    public String getRecentAction() {
        return recentAction;
    }

    public void setRecentAction(String recentAction) {
        this.recentAction = recentAction;
    }

    public String getDaysParked() {
        return daysParked;
    }

    public void setDaysParked(String daysParked) {
        this.daysParked = daysParked;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public Integer getSsa() {
        return ssa;
    }

    public void setSsa(Integer ssa) {
        this.ssa = ssa;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
