package com.dit.incidents.repository.request;

import com.dit.incidents.model.request.TreeDebrisRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeDebrisRequestRepository extends JpaRepository<TreeDebrisRequest, Long> {
}
