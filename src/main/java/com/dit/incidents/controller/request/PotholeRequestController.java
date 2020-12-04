package com.dit.incidents.controller.request;

import com.dit.incidents.external_request.request.ExternalPotholeRequest;
import com.dit.incidents.response.generic.ApiResponse;
import com.dit.incidents.service.request.PotholeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/request/pothole")
public class PotholeRequestController {

    @Autowired
    PotholeRequestService potholeRequestService;

    public ResponseEntity<?> insertPotholeRequest(@RequestBody ExternalPotholeRequest externalPotholeRequest) {
        potholeRequestService.insertPotholeRequest(externalPotholeRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Insert Pothole succeed"));
    }

}
