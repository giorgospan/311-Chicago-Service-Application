package com.dit.incidents.controller.request;

import com.dit.incidents.response.generic.ApiResponse;
import com.dit.incidents.response.search_query.*;
import com.dit.incidents.security.user.CurrentUser;
import com.dit.incidents.security.user.UserDetailsImpl;
import com.dit.incidents.service.request.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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

    // ============= The following calls are for querying data for requests ==============
    /*
     * Query 1
     * Find the total requests per type that were created within a specified time range and sort
     * them in a descending order.
     */
    @GetMapping("/query1")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query1(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Timestamp from,
                                    @RequestParam("to")   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Timestamp to,
                                    @CurrentUser UserDetailsImpl currentUser) {
        List<Response1> response1List = requestService.findTotalRequestsPerType(from, to);
        return ResponseEntity.ok().body(new ApiResponse(true, "Query 1 succeed", response1List));
    }

    /*
     * Query 2
     * Find the total requests per day for a specific request type and time range.
     */
    @GetMapping("/query2")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query2(@RequestParam("type") String type,
                                    @RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Timestamp from,
                                    @RequestParam("to")   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Timestamp to,
                                    @CurrentUser UserDetailsImpl currentUser) {
        List<Response2> response2List = requestService.findTotalRequestsPerDayBetweenTimeRange(type, from, to);
        return ResponseEntity.ok(new ApiResponse(true, "Query 2 succeed", response2List));
    }

    /*
     * Query 3
     * Find the most common service request per zipcode for a specific day.
     */
    @GetMapping("/query3")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query3(@RequestParam("targetTm") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Timestamp targetTm,
                                    @CurrentUser UserDetailsImpl currentUser) {
        List<Response3> response3List = requestService.findMostCommonTypePerZipCode(targetTm);
        return ResponseEntity.ok(new ApiResponse(true, "Query 3 succeed", response3List));
    }

    /*
     * Query 4
     * Find the average completion time per service request for a specific date range.
     */
    @GetMapping("/query4")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query4(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Timestamp from,
                                    @RequestParam("to")   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Timestamp to,
                                    @CurrentUser UserDetailsImpl currentUser) {
        List<Response4> response4List = requestService.findAvgCompletionTimePerType(from, to);
        return ResponseEntity.ok(new ApiResponse(true, "Query 4 succeed", response4List));
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
                                    @RequestParam("targetDt") Date targetDt,
                                    @CurrentUser UserDetailsImpl currentUser) {
        List<Response5> response5List = requestService.findMostCommonTypeInBoundingBox(xMin, yMin, xMax, yMax, targetDt);
        return ResponseEntity.ok(new ApiResponse(true, "Query 5 succeed", response5List));
    }

    /*
     * Query 6
     * Find the top-5 Special Service Areas (SSA) with regards to total number of requests per day
     * for a specific date range (for service requests types that SSA is available: abandoned vehicles,
     * garbage carts, graffiti removal, pot holes reported)
     */
    @GetMapping("/query6")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query6(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Timestamp from,
                                    @RequestParam("to")   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Timestamp to,
                                    @CurrentUser UserDetailsImpl currentUser) {
        List<Response6> response6List = requestService.findTopFiveSsaPerDay(from, to);
        return ResponseEntity.ok(new ApiResponse(true, "Query 6 succeed", response6List));
    }

    /*
     * Query 7
     * Find the license plates (if any) that have been involved in abandoned vehicle complaints more than once
     */
    @GetMapping("/query7")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query7(@CurrentUser UserDetailsImpl currentUser) {
        List<Response7> response7List = requestService.findLicencePlates();
        return ResponseEntity.ok(new ApiResponse(true, "Query 7 succeed", response7List));
    }

    /*
     * Query 8
     * Find the second most common color of vehicles involved in abandoned vehicle complaints.
     */
    @GetMapping("/query8")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query8(@CurrentUser UserDetailsImpl currentUser) {
        List<Response8> response8List = requestService.findSecondMostCommonColor();
        return ResponseEntity.ok(new ApiResponse(true, "Query 8 succeed", response8List));
    }

    /*
     * Query 9
     * Find the rodent baiting requests where the number of premises baited is less than a specified number.
     */
    @GetMapping("/query9")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query9(@RequestParam("targetNum") Integer targetNum, @CurrentUser UserDetailsImpl currentUser) {
        List<Response9> response9List = requestService.findRodentRequestsBaited(targetNum);
        return ResponseEntity.ok(new ApiResponse(true, "Query 9 succeed", response9List));
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
        return ResponseEntity.ok(new ApiResponse(true, "Query 10 succeed", response10List));
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
        return ResponseEntity.ok(new ApiResponse(true, "Query 11 succeed", response11List));
    }

    /*
     * Query 12
     * Find the police districts that have handled “pot holes” requests with more than one number
     * of potholes on the same day that they also handled “rodent baiting” requests with more than
     * one number of premises baited, for a specific day.
     */
    @GetMapping("/query12")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> query12(@RequestParam("targetDt") Date targetDt,
                                     @CurrentUser UserDetailsImpl currentUser) {
        List<Response12> response12List = requestService.findPoliceDistricts(targetDt);
        return ResponseEntity.ok(new ApiResponse(true, "Query 12 succeed", response12List));
    }

    /* TODO
     * Specific zip-code
     */
    @GetMapping("/queryZipCode")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> queryZipCode(@RequestParam("zipCode") String zipCode,
                                          @CurrentUser UserDetailsImpl currentUser) {
        return null;
    }

    /* TODO
     * Specific street
     */
    @GetMapping("/queryStreetAddress")
    @PreAuthorize("hasRole('BASIC')")
    public ResponseEntity<?> queryStreetAddress(@RequestParam("streetAddress") String streetAddress,
                                                @CurrentUser UserDetailsImpl currentUser) {
        return null;
    }

}
