package com.dit.incidents.repository.request;

import com.dit.incidents.model.request.SanitationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanitationRequestRepository extends JpaRepository<SanitationRequest, Long> {
}
