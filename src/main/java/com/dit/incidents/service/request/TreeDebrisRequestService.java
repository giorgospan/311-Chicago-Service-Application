package com.dit.incidents.service.request;

import com.dit.incidents.external_request.request.ExternalTreeDebrisRequest;
import com.dit.incidents.model.request.Request;
import com.dit.incidents.model.request.TreeDebrisRequest;
import com.dit.incidents.repository.request.TreeDebrisRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreeDebrisRequestService {

    @Autowired
    TreeDebrisRequestRepository treeDebrisRequestRepository;

    @Autowired
    RequestService requestService;

    public void insertTreeDebrisRequest(ExternalTreeDebrisRequest externalTreeDebrisRequest) {
        TreeDebrisRequest treeDebrisRequest = new TreeDebrisRequest(externalTreeDebrisRequest);
        Request request = requestService.insertRequest(externalTreeDebrisRequest);
        treeDebrisRequest.setRequest(request);
        treeDebrisRequestRepository.save(treeDebrisRequest);
    }
}
