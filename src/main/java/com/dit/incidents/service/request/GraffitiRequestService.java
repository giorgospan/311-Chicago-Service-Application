package com.dit.incidents.service.request;

import com.dit.incidents.external_request.request.ExternalGraffitiRequest;
import com.dit.incidents.model.request.GraffitiRequest;
import com.dit.incidents.model.request.Request;
import com.dit.incidents.repository.request.GraffitiRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraffitiRequestService {

    @Autowired
    GraffitiRequestRepository graffitiRequestRepository;

    @Autowired
    RequestService requestService;

    public void insertGraffitiRequest(ExternalGraffitiRequest externalGraffitiRequest) {
        GraffitiRequest graffitiRequest = new GraffitiRequest(externalGraffitiRequest);
        Request request = requestService.insertRequest(externalGraffitiRequest);
        graffitiRequest.setRequest(request);
        graffitiRequestRepository.save(graffitiRequest);
    }

}
