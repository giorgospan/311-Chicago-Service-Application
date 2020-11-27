package com.dit.incidents.model;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "requestId")
public class RodentRequest extends Request{

    private String currentActivity;
    private String mostRecentAction;
    private Short premisesBaited;
    private Short premisesWithGarbage;
    private Short premisesWithRats;
}
