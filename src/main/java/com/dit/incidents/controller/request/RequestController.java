package com.dit.incidents.controller.request;

import com.dit.incidents.model.response.Response1;
import com.dit.incidents.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class RequestController {

    @Autowired
    RequestRepository requestRepository;

    @GetMapping("/")
    public List<Response1> foo() throws ParseException {


        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Timestamp from = new Timestamp(dateFormat.parse("2000-12-12").getTime());
        Timestamp to = new Timestamp(dateFormat.parse("2019-12-12").getTime());
        String givenType = "Abandoned Vehicle Complaint";
        List<Response1> results  = requestRepository.countPerDayBetweenTimeRange(givenType,from,to);

        System.out.println(results.get(0).getClass());

        return results;

    }
}
