package com.dit.incidents.model.request;

import com.dit.incidents.external_request.request.ExternalGarbageRequest;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;

@Entity
public class GarbageRequest {

    @Id
    @Column(name = "GARBAGE_ID")
    private Long id;

    @Column(name = "CURRENT_ACTIVITY")
    private String currentActivity;

    @Column(name = "MOST_RECENT_ACTION")
    private String mostRecentAction;

    @Column(name = "NUM_OF_BLACK_CARTS")
    private Long numOfBlackCarts;

    @Column(name = "SSA")
    private Integer ssa;

    @OneToOne
	@MapsId
	@JoinColumn(name="REQUEST_ID")
    private Request request;

    public GarbageRequest() {
    }

    public GarbageRequest(String currentActivity, String mostRecentAction, Long numOfBlackCarts, Integer ssa, Request request) {
        this.currentActivity = currentActivity;
        this.mostRecentAction = mostRecentAction;
        this.numOfBlackCarts = numOfBlackCarts;
        this.ssa = ssa;
        this.request = request;
    }

    public GarbageRequest(Long id, String currentActivity, String mostRecentAction, Long numOfBlackCarts, Integer ssa, Request request) {
        this.id = id;
        this.currentActivity = currentActivity;
        this.mostRecentAction = mostRecentAction;
        this.numOfBlackCarts = numOfBlackCarts;
        this.ssa = ssa;
        this.request = request;
    }

    public GarbageRequest(ExternalGarbageRequest externalGarbageRequest) {
        this.currentActivity = externalGarbageRequest.getCurrentActivity();
        this.mostRecentAction = externalGarbageRequest.getMostRecentAction();
        this.numOfBlackCarts = externalGarbageRequest.getNumOfBlackCarts();
        this.ssa = externalGarbageRequest.getSsa();
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

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}



