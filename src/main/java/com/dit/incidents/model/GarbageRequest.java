package com.dit.incidents.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "requestId")
public class GarbageRequest extends Request{

    private String currentActivity;
    private String mostRecentAction;
    private Long numOfBlackCarts;
    private Integer ssa;
}
