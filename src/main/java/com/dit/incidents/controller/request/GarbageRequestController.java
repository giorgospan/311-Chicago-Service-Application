package com.dit.incidents.controller.request;

import com.dit.incidents.enums.LogQueryType;
import com.dit.incidents.external_request.request.ExternalGarbageRequest;
import com.dit.incidents.log_utils.ConstructQueryParameters;
import com.dit.incidents.response.generic.ApiResponse;
import com.dit.incidents.security.user.CurrentUser;
import com.dit.incidents.security.user.UserDetailsImpl;
import com.dit.incidents.service.log.LogService;
import com.dit.incidents.service.request.GarbageRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/request/garbage")
public class GarbageRequestController {

    @Autowired
    private GarbageRequestService garbageRequestService;

    @Autowired
    private LogService logService;

    // TODO : add logging
    @PostMapping("/insert")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> insertGarbageRequest(@RequestBody ExternalGarbageRequest externalGarbageRequest,
                                                  @CurrentUser UserDetailsImpl currentUser) {
        garbageRequestService.insertGarbageRequest(externalGarbageRequest);
        logService.insertLog(currentUser.getId(), LogQueryType.INSERT, ConstructQueryParameters.constructParamsInsert());
        return ResponseEntity.ok(new ApiResponse(true, "Insert Garbage Request succeed"));
    }

}
