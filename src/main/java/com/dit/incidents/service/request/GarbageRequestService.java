package com.dit.incidents.service.request;

import com.dit.incidents.external_request.request.ExternalGarbageRequest;
import com.dit.incidents.model.request.GarbageRequest;
import com.dit.incidents.model.request.Request;
import com.dit.incidents.repository.request.GarbageRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GarbageRequestService {

    @Autowired
    GarbageRequestRepository garbageRequestRepository;

    @Autowired
    RequestService requestService;

    public void insertGarbageRequest(ExternalGarbageRequest externalGarbageRequest) {
        GarbageRequest garbageRequest = new GarbageRequest(externalGarbageRequest);
        Request request = requestService.insertRequest(externalGarbageRequest);
        garbageRequest.setRequest(request);
        garbageRequestRepository.save(garbageRequest);
    }

}
