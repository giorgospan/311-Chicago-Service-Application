package com.dit.incidents.repository.request;

import com.dit.incidents.model.request.VehicleRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRequestRepository extends JpaRepository<VehicleRequest, Long> {
}
