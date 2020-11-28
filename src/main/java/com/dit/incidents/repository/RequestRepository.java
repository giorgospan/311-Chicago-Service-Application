package com.dit.incidents.repository;

import com.dit.incidents.model.request.Request;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RequestRepository extends PagingAndSortingRepository<Request,Long> {


    // Query 1 [Method name resolving is sufficient, not need to write the query explicitly]
    List<Request> findAllByCreationDateBetweenOrderByCreationDateDesc(Timestamp t1,Timestamp t2);

    // Query 2 [For this one we'll use jqpl]
//    List<Request> countPerDayBetweenTimeRange(@Param("type") String givenType);

}
