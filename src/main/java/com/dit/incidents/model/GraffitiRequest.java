package com.dit.incidents.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "requestId")
public class GraffitiRequest extends  Request{

    private Short ssa;
    private String graffitiSurface;
    private String graffitiLocation;

}
