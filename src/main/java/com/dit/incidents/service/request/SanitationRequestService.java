package com.dit.incidents.service.request;

import com.dit.incidents.repository.request.SanitationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SanitationRequestService {

    @Autowired
    SanitationRequestRepository sanitationRequestRepository;

}
