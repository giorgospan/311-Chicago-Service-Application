package com.dit.incidents.service.request;

import com.dit.incidents.external_request.request.ExternalPotholeRequest;
import com.dit.incidents.model.request.PotholeRequest;
import com.dit.incidents.model.request.Request;
import com.dit.incidents.repository.request.PotholeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PotholeRequestService {

    @Autowired
    PotholeRequestRepository potholeRequestRepository;

    @Autowired
    RequestService requestService;

    public void insertPotholeRequest(ExternalPotholeRequest externalPotholeRequest) {
        PotholeRequest potholeRequest = new PotholeRequest(externalPotholeRequest);
        Request request = requestService.insertRequest(externalPotholeRequest);
        potholeRequest.setRequest(request);
        potholeRequestRepository.save(potholeRequest);
    }


}
