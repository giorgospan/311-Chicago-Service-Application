package com.dit.incidents.repository.request;

import com.dit.incidents.model.request.GarbageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraffitiRequestRepository extends JpaRepository<GarbageRequest, Long> {
}
