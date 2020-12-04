package com.dit.incidents.controller.request;

import com.dit.incidents.external_request.request.ExternalRequest;
import com.dit.incidents.response.generic.ApiResponse;
import com.dit.incidents.security.user.CurrentUser;
import com.dit.incidents.security.user.UserDetailsImpl;
import com.dit.incidents.service.request.LightsOneRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/request/lightsOne")
public class LightsOneRequestController {

    @Autowired
    LightsOneRequestService lightsOneRequestService;

    @PostMapping("/insert")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> insertLightsOneRequest(@RequestBody ExternalRequest externalRequest,
                                                    @CurrentUser UserDetailsImpl currentUser) {
        lightsOneRequestService.insertLightsOneRequest(externalRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Insert Lights One succeed"));
    }

}
