package com.dit.incidents.external_request.request;

public class ExternalRodentRequest extends ExternalRequest {

    private String currentActivity;

    private String mostRecentAction;

    private Integer premisesBaited;

    private Integer premisesWithGarbage;

    private Integer premisesWithRats;

    public ExternalRodentRequest() {
    }

    public ExternalRodentRequest(String currentActivity, String mostRecentAction, Integer premisesBaited, Integer premisesWithGarbage, Integer premisesWithRats) {
        this.currentActivity = currentActivity;
        this.mostRecentAction = mostRecentAction;
        this.premisesBaited = premisesBaited;
        this.premisesWithGarbage = premisesWithGarbage;
        this.premisesWithRats = premisesWithRats;
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

    public Integer getPremisesBaited() {
        return premisesBaited;
    }

    public void setPremisesBaited(Integer premisesBaited) {
        this.premisesBaited = premisesBaited;
    }

    public Integer getPremisesWithGarbage() {
        return premisesWithGarbage;
    }

    public void setPremisesWithGarbage(Integer premisesWithGarbage) {
        this.premisesWithGarbage = premisesWithGarbage;
    }

    public Integer getPremisesWithRats() {
        return premisesWithRats;
    }

    public void setPremisesWithRats(Integer premisesWithRats) {
        this.premisesWithRats = premisesWithRats;
    }
}
