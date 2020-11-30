package com.dit.incidents.repository.request;

import com.dit.incidents.model.request.LightsOneRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightsOneRequestRepository extends JpaRepository<LightsOneRequest, Long> {
}
