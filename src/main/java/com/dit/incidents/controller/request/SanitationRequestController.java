package com.dit.incidents.controller.request;

import com.dit.incidents.external_request.request.ExternalSanitationRequest;
import com.dit.incidents.response.generic.ApiResponse;
import com.dit.incidents.service.request.SanitationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/request/sanitation")
public class SanitationRequestController {

    @Autowired
    SanitationRequestService sanitationRequestService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertSanitationRequest(@RequestBody ExternalSanitationRequest externalSanitationRequest) {
        sanitationRequestService.insertSanitationRequest(externalSanitationRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Insert Sanitation succeed"));
    }

}
