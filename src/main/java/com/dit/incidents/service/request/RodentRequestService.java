package com.dit.incidents.service.request;

import com.dit.incidents.external_request.request.ExternalRodentRequest;
import com.dit.incidents.model.request.Request;
import com.dit.incidents.model.request.RodentRequest;
import com.dit.incidents.repository.request.RodentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RodentRequestService {

    @Autowired
    RodentRequestRepository rodentRequestRepository;

    @Autowired
    RequestService requestService;

    public void insertRodentRequest(ExternalRodentRequest externalRodentRequest) {
        RodentRequest rodentRequest = new RodentRequest(externalRodentRequest);
        Request request = requestService.insertRequest(externalRodentRequest);
        rodentRequest.setRequest(request);
        rodentRequestRepository.save(rodentRequest);
    }

}
