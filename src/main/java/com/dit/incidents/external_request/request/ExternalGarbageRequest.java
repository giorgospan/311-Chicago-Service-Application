package com.dit.incidents.external_request.request;

import javax.persistence.Column;

public class ExternalGarbageRequest extends ExternalRequest {

    private String currentActivity;

    private String mostRecentAction;

    private Long numOfBlackCarts;

    private Integer ssa;

    public ExternalGarbageRequest() {
    }

    public ExternalGarbageRequest(String currentActivity, String mostRecentAction, Long numOfBlackCarts, Integer ssa) {
        this.currentActivity = currentActivity;
        this.mostRecentAction = mostRecentAction;
        this.numOfBlackCarts = numOfBlackCarts;
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

    public Long getNumOfBlackCarts() {
        return numOfBlackCarts;
    }

    public void setNumOfBlackCarts(Long numOfBlackCarts) {
        this.numOfBlackCarts = numOfBlackCarts;
    }

    public Integer getSsa() {
        return ssa;
    }

    public void setSsa(Integer ssa) {
        this.ssa = ssa;
    }
}
