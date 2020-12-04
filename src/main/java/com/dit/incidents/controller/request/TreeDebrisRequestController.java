package com.dit.incidents.controller.request;

import com.dit.incidents.external_request.request.ExternalTreeDebrisRequest;
import com.dit.incidents.response.generic.ApiResponse;
import com.dit.incidents.service.request.TreeDebrisRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/request/treeDebris")
public class TreeDebrisRequestController {

    @Autowired
    TreeDebrisRequestService treeDebrisRequestService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertTreeDebrisRequest(@RequestBody ExternalTreeDebrisRequest externalTreeDebrisRequest) {
        treeDebrisRequestService.insertTreeDebrisRequest(externalTreeDebrisRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Insert Tree Debris succeed"));
    }

}
