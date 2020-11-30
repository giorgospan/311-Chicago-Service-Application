package com.dit.incidents.service.request;

import com.dit.incidents.repository.request.LightsAllRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LightsAllRequestService {

    @Autowired
    LightsAllRequestRepository lightsAllRequestRepository;

}
