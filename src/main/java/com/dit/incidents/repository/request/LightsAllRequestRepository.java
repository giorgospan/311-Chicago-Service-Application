package com.dit.incidents.repository.request;

import com.dit.incidents.model.request.LightsAllRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightsAllRequestRepository extends JpaRepository<LightsAllRequest, Long> {
}
