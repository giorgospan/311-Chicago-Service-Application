package com.dit.incidents.service.request;

import com.dit.incidents.external_request.request.ExternalRequest;
import com.dit.incidents.model.request.Request;
import com.dit.incidents.repository.request.RequestRepository;
import com.dit.incidents.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public Request insertRequest(ExternalRequest externalRequest) {
        Request request = new Request(externalRequest);
        return requestRepository.save(request);
    }

    // Query 1
    public List<Response1> findTotalRequestsPerType(Timestamp from, Timestamp to) {
        return requestRepository.findTotalRequestsPerType(from, to);
    }

    // Query 2
    public List<Response2> findTotalRequestsPerDayBetweenTimeRange(String type, Timestamp from, Timestamp to) {
        return requestRepository.findTotalRequestsPerDayBetweenTimeRange(type, from, to);
    }

    // Query 3
    public List<Response3> findMostCommonTypePerZipCode(Timestamp targetTm) {
        return requestRepository.findMostCommonTypePerZipCode(targetTm);
    }

    // Query 4
    public List<Response4> findAvgCompletionTimePerType(Timestamp from, Timestamp to) {
        return requestRepository.findAvgCompletionTimePerType(from, to);
    }

    // Query 5
    public List<Response5> findMostCommonTypeInBoundingBox(Double xMin, Double yMin, Double xMax, Double yMax, Date targetDt) {
        return requestRepository.findMostCommonTypeInBoundingBox(xMin, yMin, xMax, yMax, targetDt);
    }

    // Query 6
    public List<Response6> findTopFiveSsaPerDay(Timestamp from, Timestamp to) {
        return requestRepository.findTopFiveSsaPerDay(from, to);
    }

    // Query 7
    public List<Response7> findLicencePlates() {
        return requestRepository.findLicencePlates();
    }

    // Query 8
    public List<Response8> findSecondMostCommonColor() {
        return requestRepository.findSecondMostCommonColor();
    }

    // Query 9
    public List<Response9> findRodentRequestsBaited(Integer targetNum) {
        return requestRepository.findRodentRequestsBaited(targetNum);
    }

    // Query 10
    public List<Response10> findRodentRequestsGarbage(Integer targetNum) {
        return requestRepository.findRodentRequestsGarbage(targetNum);
    }

    // Query 11
    public List<Response11> findRodentRequestsRats(Integer targetNum) {
        return requestRepository.findRodentRequestsRats(targetNum);
    }

    //Query 12
    public List<Response12> findPoliceDistricts(Date targetDt) {
        return requestRepository.findPoliceDistricts(targetDt);
    }

}
