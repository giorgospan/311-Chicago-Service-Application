package com.dit.incidents.service.request;

import com.dit.incidents.repository.request.RodentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RodentRequestService {

    @Autowired
    RodentRequestRepository rodentRequestRepository;

}
