package com.dit.incidents.external_request.request;

public class ExternalVehicleRequest extends ExternalRequest {

    private String currentActivity;

    private String recentAction;

    private String daysParked;

    private String licencePlate;

    private Integer ssa;

    private String vehicleColor;

    private String vehicleModel;

    public ExternalVehicleRequest() {
    }

    public ExternalVehicleRequest(String currentActivity, String recentAction, String daysParked, String licencePlate, Integer ssa, String vehicleColor, String vehicleModel) {
        this.currentActivity = currentActivity;
        this.recentAction = recentAction;
        this.daysParked = daysParked;
        this.licencePlate = licencePlate;
        this.ssa = ssa;
        this.vehicleColor = vehicleColor;
        this.vehicleModel = vehicleModel;
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
}
