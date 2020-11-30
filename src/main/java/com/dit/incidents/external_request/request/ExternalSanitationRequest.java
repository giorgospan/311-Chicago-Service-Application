package com.dit.incidents.external_request.request;

public class ExternalSanitationRequest extends ExternalRequest {

    private String nature;

    public ExternalSanitationRequest() {
    }

    public ExternalSanitationRequest(String nature) {
        this.nature = nature;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }
}
