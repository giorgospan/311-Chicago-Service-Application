package com.dit.incidents.service.request;

import com.dit.incidents.external_request.request.ExternalVehicleRequest;
import com.dit.incidents.model.request.Request;
import com.dit.incidents.model.request.VehicleRequest;
import com.dit.incidents.repository.request.VehicleRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleRequestService {

    @Autowired
    VehicleRequestRepository vehicleRequestRepository;

    @Autowired
    RequestService requestService;

    public void insertVehicleRequest(ExternalVehicleRequest externalVehicleRequest) {
        VehicleRequest vehicleRequest = new VehicleRequest(externalVehicleRequest);
        Request request = requestService.insertRequest(externalVehicleRequest);
        vehicleRequest.setRequest(request);
        vehicleRequestRepository.save(vehicleRequest);
    }

}
