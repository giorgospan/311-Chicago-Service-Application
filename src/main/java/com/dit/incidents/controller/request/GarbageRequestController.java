package com.dit.incidents.controller.request;

import com.dit.incidents.external_request.request.ExternalGarbageRequest;
import com.dit.incidents.response.generic.ApiResponse;
import com.dit.incidents.security.user.CurrentUser;
import com.dit.incidents.security.user.UserDetailsImpl;
import com.dit.incidents.service.request.GarbageRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/request/garbage")
public class GarbageRequestController {

    @Autowired
    GarbageRequestService garbageRequestService;

    // TODO : add logging
    @PostMapping("/insert")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> insertGarbageRequest(@RequestBody ExternalGarbageRequest externalGarbageRequest,
                                                  @CurrentUser UserDetailsImpl currentUser) {
        garbageRequestService.insertGarbageRequest(externalGarbageRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Insert Garbage Request succeed"));
    }

}
