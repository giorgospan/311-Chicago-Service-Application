package com.dit.incidents.model.request;


import com.dit.incidents.external_request.request.ExternalRodentRequest;

import javax.persistence.*;

@Entity
@Table(name = "RODENT_REQUEST")
public class RodentRequest{

    @Id
    @Column(name = "RODENT_ID")
    private Long id;

    @Column(name = "CURRENT_ACTIVITY")
    private String currentActivity;

    @Column(name = "MOST_RECENT_ACTION")
    private String mostRecentAction;

    @Column(name = "PREMISES_BAITED")
    private Integer premisesBaited;

    @Column(name = "PREMISES_WITH_GARBAGE")
    private Integer premisesWithGarbage;

    @Column(name = "PREMISES_WITH_RATS")
    private Integer premisesWithRats;

    @OneToOne
    @MapsId
    @JoinColumn(name="REQUEST_ID")
    private Request request;

    public RodentRequest() {
    }

    public RodentRequest(Long id, String currentActivity, String mostRecentAction, Integer premisesBaited, Integer premisesWithGarbage, Integer premisesWithRats, Request request) {
        this.id = id;
        this.currentActivity = currentActivity;
        this.mostRecentAction = mostRecentAction;
        this.premisesBaited = premisesBaited;
        this.premisesWithGarbage = premisesWithGarbage;
        this.premisesWithRats = premisesWithRats;
        this.request = request;
    }

    public RodentRequest(String currentActivity, String mostRecentAction, Integer premisesBaited, Integer premisesWithGarbage, Integer premisesWithRats, Request request) {
        this.currentActivity = currentActivity;
        this.mostRecentAction = mostRecentAction;
        this.premisesBaited = premisesBaited;
        this.premisesWithGarbage = premisesWithGarbage;
        this.premisesWithRats = premisesWithRats;
        this.request = request;
    }

    public RodentRequest(ExternalRodentRequest externalRodentRequest) {
        this.currentActivity = externalRodentRequest.getCurrentActivity();
        this.mostRecentAction = externalRodentRequest.getMostRecentAction();
        this.premisesBaited = externalRodentRequest.getPremisesBaited();
        this.premisesWithGarbage = externalRodentRequest.getPremisesWithGarbage();
        this.premisesWithRats = externalRodentRequest.getPremisesWithRats();
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

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
