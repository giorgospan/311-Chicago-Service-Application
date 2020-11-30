package com.dit.incidents.external_request.request;

public class ExternalTreeTrimRequest extends ExternalRequest {

    private String treeLocation;

    public ExternalTreeTrimRequest() {
    }

    public ExternalTreeTrimRequest(String treeLocation) {
        this.treeLocation = treeLocation;
    }

    public String getTreeLocation() {
        return treeLocation;
    }

    public void setTreeLocation(String treeLocation) {
        this.treeLocation = treeLocation;
    }
}
