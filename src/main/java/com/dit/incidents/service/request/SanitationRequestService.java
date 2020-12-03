package com.dit.incidents.service.request;

import com.dit.incidents.external_request.request.ExternalSanitationRequest;
import com.dit.incidents.model.request.Request;
import com.dit.incidents.model.request.SanitationRequest;
import com.dit.incidents.repository.request.SanitationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SanitationRequestService {

    @Autowired
    SanitationRequestRepository sanitationRequestRepository;

    @Autowired
    RequestService requestService;

    public void insertSanitationRequest(ExternalSanitationRequest externalSanitationRequest) {
        SanitationRequest sanitationRequest = new SanitationRequest(externalSanitationRequest);
        Request request = requestService.insertRequest(externalSanitationRequest);
        sanitationRequest.setRequest(request);
        sanitationRequestRepository.save(sanitationRequest);
    }

}
