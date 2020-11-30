package com.dit.incidents.repository.request;

import com.dit.incidents.model.request.RodentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RodentRequestRepository extends JpaRepository<RodentRequest, Long> {
}
