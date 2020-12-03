package com.dit.incidents.controller.request;

import com.dit.incidents.external_request.request.ExternalRequest;
import com.dit.incidents.response.ApiResponse;
import com.dit.incidents.service.request.LightsAllRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/request/lightsAll")
public class LightsAllRequestController {

    @Autowired
    LightsAllRequestService lightsAllRequestService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertLightsAllRequest(@RequestBody ExternalRequest externalRequest) {
        lightsAllRequestService.insertLightsAllRequest(externalRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Insert Lights All succeed"));
    }
}
