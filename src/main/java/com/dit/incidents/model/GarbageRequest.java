package com.dit.incidents.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "requestId")
public class GarbageRequest extends Request{

    private String location;
    private String currentActivity;
    private String mostRecentAction;
    private Short numOfBlackCarts;
    private Short ssa;
}
