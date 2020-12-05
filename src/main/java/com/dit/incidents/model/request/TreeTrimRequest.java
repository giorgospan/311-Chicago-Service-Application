package com.dit.incidents.model.request;


import com.dit.incidents.external_request.request.ExternalTreeTrimRequest;

import javax.persistence.*;

@Entity
@Table(name = "TREE_TRIM_REQUEST")
public class TreeTrimRequest{

    @Id
    @Column(name = "TREE_TRIM_ID")
    private Long id;

    @Column(name = "TREE_LOCATION")
    private String treeLocation;

    //@OneToOne(fetch = FetchType.LAZY)
    @OneToOne
    @MapsId
    @JoinColumn(name="REQUEST_ID")
    private Request request;

    public TreeTrimRequest() {
    }

    public TreeTrimRequest(Long id, String treeLocation, Request request) {
        this.id = id;
        this.treeLocation = treeLocation;
        this.request = request;
    }

    public TreeTrimRequest(String treeLocation, Request request) {
        this.treeLocation = treeLocation;
        this.request = request;
    }

    public TreeTrimRequest(ExternalTreeTrimRequest externalTreeTrimRequest) {
        this.treeLocation = externalTreeTrimRequest.getTreeLocation();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTreeLocation() {
        return treeLocation;
    }

    public void setTreeLocation(String treeLocation) {
        this.treeLocation = treeLocation;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
