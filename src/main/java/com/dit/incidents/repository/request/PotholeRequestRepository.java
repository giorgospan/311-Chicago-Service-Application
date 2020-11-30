package com.dit.incidents.repository.request;

import com.dit.incidents.model.request.PotholeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotholeRequestRepository extends JpaRepository<PotholeRequest, Long> {
}
