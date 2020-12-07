package com.dit.incidents.repository.request;

import com.dit.incidents.model.request.Request;
import com.dit.incidents.response.search_query.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
    List<Response1> findTotalRequestsPerType(@Param("from") Date from, @Param("to") Date to);

    // Query2
    @Query(value = "" +
            "select count(*) as totalRequests,date(creation_date) as day " +
            "from request " +
            "where request_type= ?1 and creation_date between ?2 and ?3 " +
            "group by 2 " +
            "order by 2 DESC ", nativeQuery = true)
    List<Response2> findTotalRequestsPerDayBetweenTimeRange(@Param("type") String givenType,
                                                            @Param("from") Date from,
                                                            @Param("to") Date to);

    // Query3
    @Query(value =
            "with cte_requests(zipCode,requestType) as( " +
            "select zip_code,request_type ," +
            "ROW_NUMBER() over (partition by  zip_code order by count(request_type) desc ) as row_num " +
            "from request " +
            "where creation_date = ?1 " +
            "group by zip_code, request_type " +
            ") " +
            "select requestType, zipCode " +
            "from cte_requests  " +
            "where row_num = 1", nativeQuery = true)
    List<Response3> findMostCommonTypePerZipCode(@Param("targetTm") Date targetTm);

    // Query4
    @Query(value = "" +
            "select request_type as requestType, avg(EXTRACT(EPOCH FROM (completion_date-creation_date))) as avgCompletionTime " +
            "from request " +
            "where creation_date between ?1 and ?2 " +
            "group by request_type", nativeQuery = true)
    List<Response4> findAvgCompletionTimePerType(@Param("from") Date from, @Param("to") Date to);

    // Query5
    @Query(value = "" +
            "select request_type as requestType, count(request_type) as typeCount " +
            "from request " +
            "where ST_MakePoint(longitude,latitude) && ST_MakeEnvelope(?1,?2,?3,?4, 4326) " +
            "and creation_date = ?5 " +
            "group by request_type " +
            "order by typeCount desc " +
            "limit 1", nativeQuery = true)
    List<Response5> findMostCommonTypeInBoundingBox(@Param("xMin") Double xMin, @Param("yMin")Double yMin,
                                                    @Param("xMax") Double xMax, @Param("yMax") Double yMax,
                                                    @Param("targetDt") Date targetDt);

    // Query6
    @Query(value = "select * from top_five_ssa(?1,?2) ", nativeQuery = true)
    List<Response6> findTopFiveSsaPerDay(@Param("from") Date from, @Param("to") Date to);

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
            "select request_id as requestId, premises_baited as premisesBaited " +
            "from rodent_request " +
            "where premises_baited < ?1 " +
            "order by 2 desc ", nativeQuery = true)
    List<Response9> findRodentRequestsBaited(@Param("targetNum") Integer targetNum);

    // Query10
    @Query(value = "" +
            "select request_id as requestId, premises_with_garbage as premisesWithGarbage " +
            "from rodent_request " +
            "where premises_with_garbage < ?1 " +
            "order by 2 desc ",nativeQuery = true)
    List<Response10> findRodentRequestsGarbage(@Param("targetNum") Integer targetNum);

    // Query11
    @Query(value = "" +
            "select request_id as requestId, premises_with_rats as premisesWithRats " +
            "from rodent_request " +
            "where premises_with_rats < ?1 " +
            "order by 2 desc",nativeQuery = true)
    List<Response11> findRodentRequestsRats(@Param("targetNum") Integer targetNum);

    // Query12
    @Query(value = "" +
            "select distinct t.police_district as policeDistrict " +
            "from " +
            "(" +
            "select request.police_district " +
            "from request inner join pothole_request pr on request.request_id = pr.request_id " +
            "where potholes_filled > 1 and creation_date = ?1 " +
            ")as t, rodent_request, request " +
            "where premises_baited > 1 " +
            "and creation_date = ?1 " +
            "and request.police_district = t.police_district " +
            "and request.request_id = rodent_request.request_id", nativeQuery = true)
    List<Response12> findPoliceDistricts(@Param("targetDt") Date targetDt);

    // Search by ZIP Code
    @Query(value = "" +
            "select request_id as requestId, date(creation_date) as creationDate, request_type as requestType " +
            "from request " +
            "where zip_code = ?1", nativeQuery = true)
    List<ResponseSearch> searchByZipCode(@Param("zipCode") String zipCode);


    // Search by Street Address
    @Query(value = "" +
            "select request_id as requestId, date(creation_date) as creationDate, request_type as requestType " +
            "from request " +
            "where street_address = ?1", nativeQuery = true)
    List<ResponseSearch> searchByStreetAddress(@Param("streetAddress") String streetAddress);

}
