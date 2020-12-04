package com.dit.incidents.controller.request;

import com.dit.incidents.external_request.request.ExternalTreeTrimRequest;
import com.dit.incidents.response.generic.ApiResponse;
import com.dit.incidents.security.user.CurrentUser;
import com.dit.incidents.security.user.UserDetailsImpl;
import com.dit.incidents.service.request.TreeTrimRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/request/treeTrim")
public class TreeTrimRequestController {

    @Autowired
    TreeTrimRequestService treeTrimRequestService;

    @PostMapping("/insert")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> insertTreeTrimRequest(@RequestBody ExternalTreeTrimRequest externalTreeTrimRequest,
                                                   @CurrentUser UserDetailsImpl currentUser) {
        treeTrimRequestService.insertTreeTrimRequest(externalTreeTrimRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Insert Tree Trim succeed"));
    }

}
