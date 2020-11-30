package com.dit.incidents.external_request.request;

public class ExternalPotholeRequest extends ExternalRequest {

    private String currentActivity;

    private String mostRecentAction;

    private Integer potholesFilled;

    private Integer ssa;

    public ExternalPotholeRequest() {
    }

    public ExternalPotholeRequest(String currentActivity, String mostRecentAction, Integer potholesFilled, Integer ssa) {
        this.currentActivity = currentActivity;
        this.mostRecentAction = mostRecentAction;
        this.potholesFilled = potholesFilled;
        this.ssa = ssa;
    }

    public String getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(String currentActivity) {
        this.currentActivity = currentActivity;
    }

    public String getMostRecentAction() {
        return mostRecentAction;
    }

    public void setMostRecentAction(String mostRecentAction) {
        this.mostRecentAction = mostRecentAction;
    }

    public Integer getPotholesFilled() {
        return potholesFilled;
    }

    public void setPotholesFilled(Integer potholesFilled) {
        this.potholesFilled = potholesFilled;
    }

    public Integer getSsa() {
        return ssa;
    }

    public void setSsa(Integer ssa) {
        this.ssa = ssa;
    }
}
