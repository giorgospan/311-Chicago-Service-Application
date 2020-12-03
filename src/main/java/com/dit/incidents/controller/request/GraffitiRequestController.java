package com.dit.incidents.controller.request;

import com.dit.incidents.external_request.request.ExternalGraffitiRequest;
import com.dit.incidents.response.ApiResponse;
import com.dit.incidents.service.request.GraffitiRequestService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/request/graffiti")
public class GraffitiRequestController {

    @Autowired
    GraffitiRequestService graffitiRequestService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertGraffitiRequest(@RequestBody ExternalGraffitiRequest externalGraffitiRequest) {
        graffitiRequestService.insertGraffitiRequest(externalGraffitiRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Insert Graffiti Request succeed"));
    }
}
