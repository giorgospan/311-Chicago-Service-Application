package com.dit.incidents.repository;

import com.dit.incidents.model.request.Request;
import com.dit.incidents.model.response.Response1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {


    // Query 1 [Method name resolving is sufficient, not need to write the query explicitly]
    List<Request> findAllByCreationDateBetweenOrderByCreationDateDesc(Timestamp t1,Timestamp t2);


    // Query2 [Named parameters are not supported in native queries]
    @Query(value = "select count(*) as totalRequests,date(creation_date) as day " +
            "from request " +
            "where request_type= ?1 and creation_date between ?2 and ?3 " +
            "group by 2 " +
            "order by 2 DESC ", nativeQuery = true)
    List<Response1> countPerDayBetweenTimeRange(@Param("type") String givenType,
                                                @Param("from") Timestamp from,
                                                @Param("to") Timestamp to);

}
