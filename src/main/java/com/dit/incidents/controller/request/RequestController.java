package com.dit.incidents.controller.request;

import com.dit.incidents.enums.LogQueryType;
import com.dit.incidents.log_utils.ConstructQueryParameters;
import com.dit.incidents.response.search_query.*;
import com.dit.incidents.security.user.CurrentUser;
import com.dit.incidents.security.user.UserDetailsImpl;
import com.dit.incidents.service.log.LogService;
import com.dit.incidents.service.request.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/*
 * Endpoints of the queries are in the form of : '/app/queryId, Id = [1,...,12] (Use Get)
 */
@RestController
@RequestMapping("/app")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private LogService logService;

    // ============= The following calls are for querying data for requests ==============
    /*
     * Query 1
     * Find the total requests per type that were created within a specified time range and sort
     * them in a descending order.
     */
    @GetMapping("/query1")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query1(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date from,
                                    @RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") Date to,
                                    @CurrentUser UserDetailsImpl currentUser) {
        List<Response1> response1List = requestService.findTotalRequestsPerType(from, to);
        logService.insertLog(currentUser.getId(), LogQueryType.QUERY1, ConstructQueryParameters.constructParamsQuery1(from, to));
        return ResponseEntity.ok(response1List);
//        return ResponseEntity.ok().body(new ApiResponse(true, "Query 1 succeed", response1List));
    }

    /*
     * Query 2
     * Find the total requests per day for a specific request type and time range.
     */
    @GetMapping("/query2")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query2(@RequestParam("type") String type,
                                    @RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date from,
                                    @RequestParam("to")   @DateTimeFormat(pattern="yyyy-MM-dd") Date to,
                                    @CurrentUser UserDetailsImpl currentUser) {
        List<Response2> response2List = requestService.findTotalRequestsPerDayBetweenTimeRange(type, from, to);
        logService.insertLog(currentUser.getId(), LogQueryType.QUERY2, ConstructQueryParameters.constructParamsQuery2(type, from, to));
        return ResponseEntity.ok(response2List);
//        return ResponseEntity.ok(new ApiResponse(true, "Query 2 succeed", response2List));
    }

    /*
     * Query 3
     * Find the most common service request per zipcode for a specific day.
     */
    @GetMapping("/query3")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query3(@RequestParam("targetTm") @DateTimeFormat(pattern="yyyy-MM-dd") Date targetTm,
                                    @CurrentUser UserDetailsImpl currentUser) {
        List<Response3> response3List = requestService.findMostCommonTypePerZipCode(targetTm);
        logService.insertLog(currentUser.getId(), LogQueryType.QUERY3, ConstructQueryParameters.constructParamsQuery3(targetTm));
        return ResponseEntity.ok(response3List);
//        return ResponseEntity.ok(new ApiResponse(true, "Query 3 succeed", response3List));
    }

    /*
     * Query 4
     * Find the average completion time per service request for a specific date range.
     */
    @GetMapping("/query4")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query4(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date from,
                                    @RequestParam("to")   @DateTimeFormat(pattern="yyyy-MM-dd") Date to,
                                    @CurrentUser UserDetailsImpl currentUser) {
        List<Response4> response4List = requestService.findAvgCompletionTimePerType(from, to);
        logService.insertLog(currentUser.getId(), LogQueryType.QUERY4, ConstructQueryParameters.constructParamsQuery4(from, to));
        return ResponseEntity.ok(response4List);
//        return ResponseEntity.ok(new ApiResponse(true, "Query 4 succeed", response4List));
    }

    /*
     * Query 5
     * Find the most common service request in a specified bounding box
     * (as designated by GPS-coordinates) for a specific day.
     */
    @GetMapping("/query5")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query5(@RequestParam("xMin") Double xMin, @RequestParam("yMin") Double yMin,
                                    @RequestParam("xMax") Double xMax, @RequestParam("yMax") Double yMax,
                                    @RequestParam("targetDt") @DateTimeFormat(pattern="yyyy-MM-dd") Date targetDt,
                                    @CurrentUser UserDetailsImpl currentUser) {
        List<Response5> response5List = requestService.findMostCommonTypeInBoundingBox(xMin, yMin, xMax, yMax, targetDt);
        logService.insertLog(currentUser.getId(), LogQueryType.QUERY5, ConstructQueryParameters.constructParamsQuery5(xMin, yMin, xMax, yMax, targetDt));
        return ResponseEntity.ok(response5List);
//        return ResponseEntity.ok(new ApiResponse(true, "Query 5 succeed", response5List));
    }

    /*
     * Query 6
     * Find the top-5 Special Service Areas (SSA) with regards to total number of requests per day
     * for a specific date range (for service requests types that SSA is available: abandoned vehicles,
     * garbage carts, graffiti removal, pot holes reported)
     */
    @GetMapping("/query6")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query6(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date from,
                                    @RequestParam("to")   @DateTimeFormat(pattern="yyyy-MM-dd") Date to,
                                    @CurrentUser UserDetailsImpl currentUser) {
        List<Response6> response6List = requestService.findTopFiveSsaPerDay(from, to);
        logService.insertLog(currentUser.getId(), LogQueryType.QUERY6, ConstructQueryParameters.constructParamsQuery6(from, to));
        return ResponseEntity.ok(response6List);
//        return ResponseEntity.ok(new ApiResponse(true, "Query 6 succeed", response6List));
    }

    /*
     * Query 7
     * Find the license plates (if any) that have been involved in abandoned vehicle complaints more than once
     */
    @GetMapping("/query7")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query7(@CurrentUser UserDetailsImpl currentUser) {
        List<Response7> response7List = requestService.findLicencePlates();
        logService.insertLog(currentUser.getId(), LogQueryType.QUERY7, ConstructQueryParameters.constructParamsQuery7());
        return ResponseEntity.ok(response7List);
//        return ResponseEntity.ok(new ApiResponse(true, "Query 7 succeed", response7List));
    }

    /*
     * Query 8
     * Find the second most common color of vehicles involved in abandoned vehicle complaints.
     */
    @GetMapping("/query8")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query8(@CurrentUser UserDetailsImpl currentUser) {
        List<Response8> response8List = requestService.findSecondMostCommonColor();
        logService.insertLog(currentUser.getId(), LogQueryType.QUERY8, ConstructQueryParameters.constructParamsQuery8());
        return ResponseEntity.ok(response8List);
//        return ResponseEntity.ok(new ApiResponse(true, "Query 8 succeed", response8List));
    }

    /*
     * Query 9
     * Find the rodent baiting requests where the number of premises baited is less than a specified number.
     */
    @GetMapping("/query9")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query9(@RequestParam("targetNum") Integer targetNum, @CurrentUser UserDetailsImpl currentUser) {
        List<Response9> response9List = requestService.findRodentRequestsBaited(targetNum);
        logService.insertLog(currentUser.getId(), LogQueryType.QUERY9, ConstructQueryParameters.constructParamsQuery9(targetNum));
        return ResponseEntity.ok(response9List);
//        return ResponseEntity.ok(new ApiResponse(true, "Query 9 succeed", response9List));
    }

    /*
     * Query 10
     * Same as the above (i.e., Query 9) for premises with garbage.
     */
    @GetMapping("/query10")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query10(@RequestParam("targetNum") Integer targetNum,
                                     @CurrentUser UserDetailsImpl currentUser) {
        List<Response10> response10List = requestService.findRodentRequestsGarbage(targetNum);
        logService.insertLog(currentUser.getId(), LogQueryType.QUERY10, ConstructQueryParameters.constructParamsQuery10(targetNum));
        return ResponseEntity.ok(response10List);
//        return ResponseEntity.ok(new ApiResponse(true, "Query 10 succeed", response10List));
    }

    /*
     * Query 11
     * Same as the above (i.e., Query 10) for premises with rats.
     */
    @GetMapping("/query11")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query11(@RequestParam("targetNum") Integer targetNum,
                                     @CurrentUser UserDetailsImpl currentUser) {
        List<Response11> response11List = requestService.findRodentRequestsRats(targetNum);
        logService.insertLog(currentUser.getId(), LogQueryType.QUERY11, ConstructQueryParameters.constructParamsQuery11(targetNum));
        return ResponseEntity.ok(response11List);
//        return ResponseEntity.ok(new ApiResponse(true, "Query 11 succeed", response11List));
    }

    /*
     * Query 12
     * Find the police districts that have handled “pot holes” requests with more than one number
     * of potholes on the same day that they also handled “rodent baiting” requests with more than
     * one number of premises baited, for a specific day.
     */
    @GetMapping("/query12")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query12(@RequestParam("targetDt") @DateTimeFormat(pattern="yyyy-MM-dd") Date targetDt,
                                     @CurrentUser UserDetailsImpl currentUser) {
        List<Response12> response12List = requestService.findPoliceDistricts(targetDt);
        logService.insertLog(currentUser.getId(), LogQueryType.QUERY12, ConstructQueryParameters.constructParamsQuery12(targetDt));
        return ResponseEntity.ok(response12List);
//        return ResponseEntity.ok(new ApiResponse(true, "Query 12 succeed", response12List));
    }

    /*
     * Search for Specific zip-code
     */
    @GetMapping("/queryZipCode")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> queryZipCode(@RequestParam("zipCode") String zipCode,
                                          @CurrentUser UserDetailsImpl currentUser) {
        List<ResponseSearch> zipResponseList = requestService.findByZipCode(zipCode);
        logService.insertLog(currentUser.getId(), LogQueryType.QUERY_ZIP_CODE, ConstructQueryParameters.constructParamsQueryZipCode(zipCode));
        return ResponseEntity.ok(zipResponseList);
    }

    /*
     * Search for a specific street address
     */
    @GetMapping("/queryStreetAddress")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> queryStreetAddress(@RequestParam("streetAddress") String streetAddress,
                                                @CurrentUser UserDetailsImpl currentUser) {
        List<ResponseSearch> searchResponseList = requestService.findByStreetAddress(streetAddress);
        logService.insertLog(currentUser.getId(), LogQueryType.QUERY_STREET_ADDRESS, ConstructQueryParameters.constructParamsQueryStreetAddress(streetAddress));
        return ResponseEntity.ok(searchResponseList);
    }

}
