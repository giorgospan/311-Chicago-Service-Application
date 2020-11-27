package com.dit.incidents.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "requestId")
public class TreeDebrisRequest extends Request{

    private String currentActivity;
    private String mostRecentAction;
    private String debrisLocation;
}
