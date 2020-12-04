package com.dit.incidents.controller.request;

import com.dit.incidents.external_request.request.ExternalRequest;
import com.dit.incidents.response.generic.ApiResponse;
import com.dit.incidents.service.request.AlleyLightsRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/request/alleyLights")
public class AlleyLightsRequestController {

    @Autowired
    AlleyLightsRequestService alleyLightsRequestService;

    // TODO : add logging
    @PostMapping("/insert")
    public ResponseEntity<?> insertAlleyLightsRequest(@RequestBody ExternalRequest externalRequest) {
        alleyLightsRequestService.insertAlleyLightsRequest(externalRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Insert Alley Lights Request succeed"));
    }

}
