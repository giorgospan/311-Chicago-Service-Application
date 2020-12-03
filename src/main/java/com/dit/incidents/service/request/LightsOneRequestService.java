package com.dit.incidents.service.request;

import com.dit.incidents.external_request.request.ExternalRequest;
import com.dit.incidents.model.request.LightsOneRequest;
import com.dit.incidents.model.request.Request;
import com.dit.incidents.repository.request.LightsOneRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LightsOneRequestService {

    @Autowired
    LightsOneRequestRepository lightsOneRequestRepository;

    @Autowired
    RequestService requestService;

    public void insertLightsOneRequest(ExternalRequest externalRequest) {
        LightsOneRequest lightsOneRequest = new LightsOneRequest();
        Request request = requestService.insertRequest(externalRequest);
        lightsOneRequest.setRequest(request);
        lightsOneRequestRepository.save(lightsOneRequest);
    }

}
