package com.dit.incidents.external_request.request;

import javax.persistence.Column;

public class ExternalTreeDebrisRequest extends ExternalRequest {

    private String currentActivity;

    private String mostRecentAction;

    private String debrisLocation;

    public ExternalTreeDebrisRequest() {
    }

    public ExternalTreeDebrisRequest(String currentActivity, String mostRecentAction, String debrisLocation) {
        this.currentActivity = currentActivity;
        this.mostRecentAction = mostRecentAction;
        this.debrisLocation = debrisLocation;
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

    public String getDebrisLocation() {
        return debrisLocation;
    }

    public void setDebrisLocation(String debrisLocation) {
        this.debrisLocation = debrisLocation;
    }
}
