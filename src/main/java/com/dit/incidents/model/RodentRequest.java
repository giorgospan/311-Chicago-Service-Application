package com.dit.incidents.model;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "requestId")
public class RodentRequest extends Request{

    private String currentActivity;
    private String mostRecentAction;
    private Integer premisesBaited;
    private Integer premisesWithGarbage;
    private Integer premisesWithRats;
}
