package com.dit.incidents.repository.request;

import com.dit.incidents.model.request.TreeTrimRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeTrimRequestRepository extends JpaRepository<TreeTrimRequest, Long> {
}
