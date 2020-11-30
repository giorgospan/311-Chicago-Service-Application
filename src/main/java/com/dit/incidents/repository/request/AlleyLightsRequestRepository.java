package com.dit.incidents.repository.request;

import com.dit.incidents.model.request.AlleyLightsRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlleyLightsRequestRepository extends JpaRepository<AlleyLightsRequest, Long> {
}
