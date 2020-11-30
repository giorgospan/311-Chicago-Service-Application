package com.dit.incidents.service.request;

import com.dit.incidents.repository.request.TreeDebrisRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreeDebrisRequestService {

    @Autowired
    TreeDebrisRequestRepository treeDebrisRequestRepository;

}
