package com.dit.incidents.service.request;

import com.dit.incidents.repository.request.AlleyLightsRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlleyLightsRequestService {

    @Autowired
    private AlleyLightsRequestRepository alleyLightsRequestRepository;

}
