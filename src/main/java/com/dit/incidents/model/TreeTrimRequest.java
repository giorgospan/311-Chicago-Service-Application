package com.dit.incidents.model;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "requestId")
public class TreeTrimRequest extends Request{

    private String treeLocation;
}
