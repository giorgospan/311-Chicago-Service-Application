package com.dit.incidents.model.request;

import com.dit.incidents.external_request.request.ExternalPotholeRequest;

import javax.persistence.*;

@Entity
@Table(name = "POTHOLE_REQUEST")
public class PotholeRequest{

    @Id
    @Column(name = "PLOTHOLE_ID")
    private Long id;

    @Column(name = "CURRENT_ACTIVITY")
    private String currentActivity;

    @Column(name = "MOST_RECENT_ACTION")
    private String mostRecentAction;

    @Column(name = "POTHOLES_FILLED")
    private Integer potholesFilled;

    @Column(name = "SSA")
    private Integer ssa;

    //@OneToOne(fetch = FetchType.LAZY)
    @OneToOne
    @MapsId
    @JoinColumn(name="REQUEST_ID")
    private Request request;

    public PotholeRequest() {
    }

    public PotholeRequest(String currentActivity, String mostRecentAction, Integer potholesFilled, Integer ssa, Request request) {
        this.currentActivity = currentActivity;
        this.mostRecentAction = mostRecentAction;
        this.potholesFilled = potholesFilled;
        this.ssa = ssa;
        this.request = request;
    }

    public PotholeRequest(Long id, String currentActivity, String mostRecentAction, Integer potholesFilled, Integer ssa, Request request) {
        this.id = id;
        this.currentActivity = currentActivity;
        this.mostRecentAction = mostRecentAction;
        this.potholesFilled = potholesFilled;
        this.ssa = ssa;
        this.request = request;
    }

    public PotholeRequest(ExternalPotholeRequest externalPotholeRequest) {
        this.currentActivity = externalPotholeRequest.getCurrentActivity();
        this.potholesFilled = externalPotholeRequest.getPotholesFilled();
        this.ssa = externalPotholeRequest.getSsa();
        this.mostRecentAction = externalPotholeRequest.getMostRecentAction();
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

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
