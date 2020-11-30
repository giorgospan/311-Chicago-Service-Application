package com.dit.incidents.service.request;

import com.dit.incidents.repository.request.GraffitiRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraffitiRequestService {

    @Autowired
    GraffitiRequestRepository graffitiRequestRepository;

}
