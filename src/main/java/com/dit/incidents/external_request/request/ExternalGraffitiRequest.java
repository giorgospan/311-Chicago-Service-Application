package com.dit.incidents.external_request.request;

public class ExternalGraffitiRequest extends ExternalRequest{

    private Integer ssa;

    private String graffitiSurface;

    private String graffitiLocation;

    public ExternalGraffitiRequest() {
    }

    public ExternalGraffitiRequest(Integer ssa, String graffitiSurface, String graffitiLocation) {
        this.ssa = ssa;
        this.graffitiSurface = graffitiSurface;
        this.graffitiLocation = graffitiLocation;
    }

    public Integer getSsa() {
        return ssa;
    }

    public void setSsa(Integer ssa) {
        this.ssa = ssa;
    }

    public String getGraffitiSurface() {
        return graffitiSurface;
    }

    public void setGraffitiSurface(String graffitiSurface) {
        this.graffitiSurface = graffitiSurface;
    }

    public String getGraffitiLocation() {
        return graffitiLocation;
    }

    public void setGraffitiLocation(String graffitiLocation) {
        this.graffitiLocation = graffitiLocation;
    }
}
