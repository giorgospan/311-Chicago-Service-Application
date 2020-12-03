package com.dit.incidents.service.request;

import com.dit.incidents.controller.request.TreeTrimRequestController;
import com.dit.incidents.external_request.request.ExternalTreeDebrisRequest;
import com.dit.incidents.external_request.request.ExternalTreeTrimRequest;
import com.dit.incidents.model.request.Request;
import com.dit.incidents.model.request.TreeTrimRequest;
import com.dit.incidents.repository.request.TreeTrimRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreeTrimRequestService {

    @Autowired
    TreeTrimRequestRepository treeTrimRequestRepository;

    @Autowired
    RequestService requestService;

    public void insertTreeTrimRequest(ExternalTreeTrimRequest externalTreeTrimRequest) {
        TreeTrimRequest treeTrimRequest = new TreeTrimRequest(externalTreeTrimRequest);
        Request request = requestService.insertRequest(externalTreeTrimRequest);
        treeTrimRequest.setRequest(request);
        treeTrimRequestRepository.save(treeTrimRequest);
    }

}
