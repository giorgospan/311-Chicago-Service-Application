package com.dit.incidents.controller.request;

import com.dit.incidents.enums.LogQueryType;
import com.dit.incidents.external_request.request.ExternalRequest;
import com.dit.incidents.log_utils.ConstructQueryParameters;
import com.dit.incidents.response.generic.ApiResponse;
import com.dit.incidents.security.user.CurrentUser;
import com.dit.incidents.security.user.UserDetailsImpl;
import com.dit.incidents.service.log.LogService;
import com.dit.incidents.service.request.LightsAllRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/request")
@CrossOrigin
public class LightsAllRequestController {

    @Autowired
    private LightsAllRequestService lightsAllRequestService;

    @Autowired
    private LogService logService;

    @PostMapping("/lightsAll")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> insertLightsAllRequest(@RequestBody ExternalRequest externalRequest,
                                                    @CurrentUser UserDetailsImpl currentUser) {
        lightsAllRequestService.insertLightsAllRequest(externalRequest);
        logService.insertLog(currentUser.getId(), LogQueryType.INSERT, ConstructQueryParameters.constructParamsInsert());
        return ResponseEntity.ok(new ApiResponse(true, "Insert Lights All succeed"));
    }
}
