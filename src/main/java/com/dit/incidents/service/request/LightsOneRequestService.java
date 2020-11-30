package com.dit.incidents.service.request;

import com.dit.incidents.repository.request.LightsOneRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LightsOneRequestService {

    @Autowired
    LightsOneRequestRepository lightsOneRequestRepository;

}
