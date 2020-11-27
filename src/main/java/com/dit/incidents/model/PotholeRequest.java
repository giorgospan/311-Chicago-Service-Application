package com.dit.incidents.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "requestId")
public class PotholeRequest extends Request {

    private String currentActivity;
    private String mostRecentAction;
    private Short potholesFilled;
    private Short ssa;
}
