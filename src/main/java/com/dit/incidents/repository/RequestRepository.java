package com.dit.incidents.repository;

import com.dit.incidents.model.request.Request;
import com.dit.incidents.model.response.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {


    // Query 1
    @Query(value = "" +
            "select request_type as requestType, count(*) as totalRequests " +
            "from request " +
            "where creation_date between ?1 and ?2 " +
            "group by request_type " +
            "order by totalRequests DESC", nativeQuery = true)
    List<Response1> findTotalRequestsPerType(Timestamp t1, Timestamp t2);


    // Query2
    @Query(value = "" +
            "select count(*) as totalRequests,date(creation_date) as day " +
            "from request " +
            "where request_type= ?1 and creation_date between ?2 and ?3 " +
            "group by 2 " +
            "order by 2 DESC ", nativeQuery = true)
    List<Response2> findTotalRequestsPerDayBetweenTimeRange(@Param("type") String givenType,
                                                @Param("from") Timestamp t1,
                                                @Param("to") Timestamp t2);

    // Query3
    @Query(value =
            "with cte_requests(zipCode,requestType) as( " +
            "select zip_code,request_type ," +
            "ROW_NUMBER() over (partition by  zip_code order by count(request_type) desc ) as row_num " +
            "from request " +
            "where date(creation_date) = ?1 " +
            "group by zip_code, request_type " +
            ") " +
            "select requestType, zipCode " +
            "from cte_requests  " +
            "where row_num = 1", nativeQuery = true)
    List<Response3> findMostCommonTypePerZipCode(Timestamp t);

    // Query4
    @Query(value = "" +
            "select request_type as requestType, avg(EXTRACT(EPOCH FROM (completion_date-creation_date))) as avgCompletionTime " +
            "from request " +
            "where date(creation_date) between ?1 and ?2 " +
            "group by request_type", nativeQuery = true)
    List<Response4> findAvgCompletionTimePerType(Timestamp t1,Timestamp t2);


    // Query5
    @Query(value = "" +
            "select request_type as requestType, count(request_type) as typeCount " +
            "from request " +
            "where ST_MakePoint(longitude,latitude) && ST_MakeEnvelope(?1,?2,?3,?4, 4326) " +
            "and date(creation_date) = ?5 " +
            "group by request_type " +
            "order by typeCount desc "
            ,nativeQuery = true)
    List<Response5> findMostCommonTypeInBoundingBox(Double xMin, Double yMin, Double xMax, Double yMax, Date day);

    // Query6
    @Query(value = "select * from top_five_ssa(?1,?2) ", nativeQuery = true)
    List<Response6> findTopFiveSsaPerDay(Timestamp t1,Timestamp t2);

    // Query7
    @Query(value = "" +
            "select licence_plate as licencePlate, count(*) as counts " +
            "from vehicle_request " +
            "where licence_plate is not null " +
            "group by licence_plate " +
            "having count(*)  > 1 " +
            "order by count(*) desc ",nativeQuery = true)
    List<Response7> findLicencePlates();


    // Query8
    @Query(value = "" +
            "select vehicle_color as color, COUNT(vehicle_color) as counts " +
            "from vehicle_request " +
            "group by color " +
            "order by counts desc " +
            "limit 1 offset 1", nativeQuery = true)
    List<Response8> findSecondMostCommonColor();

    // Query9
    @Query(value = "" +
            "select request_id as requestId " +
            "from rodent_request " +
            "where premises_baited < ?1",nativeQuery = true)
    List<Response9> findRodentRequestsBaited(Integer num);

    // Query10
    @Query(value = "" +
            "select request_id as requestId " +
            "from rodent_request " +
            "where premises_with_garbage < ?1",nativeQuery = true)
    List<Response10> findRodentRequestsGarbage(Integer num);

    // Query11
    @Query(value = "" +
            "select request_id as requestId " +
            "from rodent_request " +
            "where premises_with_rats < ?1",nativeQuery = true)
    List<Response11> findRodentRequestsRats(Integer num);


    // Query12
    @Query(value = "" +
            "select request_id as requestId " +
            "from" +
            "(" +
            "select request.request_id " +
            "from request inner join pothole_request on request.request_id = pothole_request.request_id " +
            "where potholes_filled > 1 and date(creation_date) = ?1 " +
            ")as t " +
            "where exists " +
            "( " +
            "select request.request_id " +
            "from request inner join rodent_request on request.request_id = rodent_request.request_id " +
            "where premises_baited > 1 and date(creation_date) = ?1" +
            ")", nativeQuery = true)
    List<Response12> findPoliceDistricts(Date day);
}
