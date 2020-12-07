package com.dit.incidents.controller.request;

import com.dit.incidents.enums.LogQueryType;
import com.dit.incidents.external_request.request.ExternalPotholeRequest;
import com.dit.incidents.log_utils.ConstructQueryParameters;
import com.dit.incidents.response.generic.ApiResponse;
import com.dit.incidents.security.user.CurrentUser;
import com.dit.incidents.security.user.UserDetailsImpl;
import com.dit.incidents.service.log.LogService;
import com.dit.incidents.service.request.PotholeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/app/request")
public class PotholeRequestController {

    @Autowired
    private PotholeRequestService potholeRequestService;

    @Autowired
    private LogService logService;

    @PostMapping("/pothole")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> insertPotholeRequest(@RequestBody ExternalPotholeRequest externalPotholeRequest,
                                                  @CurrentUser UserDetailsImpl currentUser) {
        potholeRequestService.insertPotholeRequest(externalPotholeRequest);
        logService.insertLog(currentUser.getId(), LogQueryType.INSERT, ConstructQueryParameters.constructParamsInsert());
        return ResponseEntity.ok(new ApiResponse(true, "Insert Pothole succeed"));
    }

}
