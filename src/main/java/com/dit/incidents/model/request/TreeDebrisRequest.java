package com.dit.incidents.model.request;

import com.dit.incidents.external_request.request.ExternalTreeDebrisRequest;
import com.sun.source.tree.Tree;

import javax.persistence.*;

@Entity(name = "TREE_DEBRIS_REQUEST")
public class TreeDebrisRequest{

    @Id
    @Column(name = "TREE_DEBRIS_ID")
    private Long id;

    @Column(name = "CURRENT_ACTIVITY")
    private String currentActivity;

    @Column(name = "MOST_RECENT_ACTION")
    private String mostRecentAction;

    @Column(name = "DEBRIS_LOCATION")
    private String debrisLocation;

    @OneToOne
    @MapsId
    @JoinColumn(name="REQUEST_ID")
    private Request request;

    public TreeDebrisRequest() {
    }

    public TreeDebrisRequest(Long id, String currentActivity, String mostRecentAction, String debrisLocation, Request request) {
        this.id = id;
        this.currentActivity = currentActivity;
        this.mostRecentAction = mostRecentAction;
        this.debrisLocation = debrisLocation;
        this.request = request;
    }

    public TreeDebrisRequest(String currentActivity, String mostRecentAction, String debrisLocation, Request request) {
        this.currentActivity = currentActivity;
        this.mostRecentAction = mostRecentAction;
        this.debrisLocation = debrisLocation;
        this.request = request;
    }

    public TreeDebrisRequest(ExternalTreeDebrisRequest externalTreeDebrisRequest) {
        this.currentActivity = externalTreeDebrisRequest.getCurrentActivity();
        this.mostRecentAction = externalTreeDebrisRequest.getMostRecentAction();
        this.debrisLocation = externalTreeDebrisRequest.getDebrisLocation();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
