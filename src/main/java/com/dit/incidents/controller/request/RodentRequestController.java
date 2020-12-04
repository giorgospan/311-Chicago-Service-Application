package com.dit.incidents.controller.request;

import com.dit.incidents.external_request.request.ExternalRodentRequest;
import com.dit.incidents.response.generic.ApiResponse;
import com.dit.incidents.service.request.RodentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/request/rodent")
public class RodentRequestController {

    @Autowired
    RodentRequestService rodentRequestService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertRodentRequest(@RequestParam ExternalRodentRequest externalRodentRequest) {
        rodentRequestService.insertRodentRequest(externalRodentRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Insert Rodent Request Succedd"));
    }

}
