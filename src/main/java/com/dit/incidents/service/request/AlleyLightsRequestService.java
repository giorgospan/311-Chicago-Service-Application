package com.dit.incidents.service.request;

import com.dit.incidents.external_request.request.ExternalRequest;
import com.dit.incidents.model.request.AlleyLightsRequest;
import com.dit.incidents.model.request.Request;
import com.dit.incidents.repository.request.AlleyLightsRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlleyLightsRequestService {

    @Autowired
    private AlleyLightsRequestRepository alleyLightsRequestRepository;

    @Autowired
    private RequestService requestService;

    public void insertAlleyLightsRequest(ExternalRequest externalRequest) {
        AlleyLightsRequest alleyLightsRequest = new AlleyLightsRequest();
        Request request = requestService.insertRequest(externalRequest);
        alleyLightsRequest.setRequest(request);
        alleyLightsRequestRepository.save(alleyLightsRequest);
    }

}
