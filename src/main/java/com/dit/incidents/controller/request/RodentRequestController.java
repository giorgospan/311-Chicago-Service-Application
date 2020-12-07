package com.dit.incidents.controller.request;

import com.dit.incidents.enums.LogQueryType;
import com.dit.incidents.external_request.request.ExternalRodentRequest;
import com.dit.incidents.log_utils.ConstructQueryParameters;
import com.dit.incidents.response.generic.ApiResponse;
import com.dit.incidents.security.user.CurrentUser;
import com.dit.incidents.security.user.UserDetailsImpl;
import com.dit.incidents.service.log.LogService;
import com.dit.incidents.service.request.RodentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/app/request")
public class RodentRequestController {

    @Autowired
    private RodentRequestService rodentRequestService;

    @Autowired
    private LogService logService;

    @PostMapping("/rodent")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> insertRodentRequest(@RequestParam ExternalRodentRequest externalRodentRequest,
                                                 @CurrentUser UserDetailsImpl currentUser) {
        rodentRequestService.insertRodentRequest(externalRodentRequest);
        logService.insertLog(currentUser.getId(), LogQueryType.INSERT, ConstructQueryParameters.constructParamsInsert());
        return ResponseEntity.ok(new ApiResponse(true, "Insert Rodent Request succeed"));
    }

}
