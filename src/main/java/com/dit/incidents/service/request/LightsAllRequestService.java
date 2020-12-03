package com.dit.incidents.service.request;

import com.dit.incidents.external_request.request.ExternalRequest;
import com.dit.incidents.model.request.AlleyLightsRequest;
import com.dit.incidents.model.request.LightsAllRequest;
import com.dit.incidents.model.request.Request;
import com.dit.incidents.repository.request.LightsAllRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LightsAllRequestService {

    @Autowired
    LightsAllRequestRepository lightsAllRequestRepository;

    @Autowired
    private RequestService requestService;

    public void insertLightsAllRequest(ExternalRequest externalRequest) {
        LightsAllRequest lightsAllRequest = new LightsAllRequest();
        Request request = requestService.insertRequest(externalRequest);
        lightsAllRequest.setRequest(request);
        lightsAllRequestRepository.save(lightsAllRequest);
    }

}
