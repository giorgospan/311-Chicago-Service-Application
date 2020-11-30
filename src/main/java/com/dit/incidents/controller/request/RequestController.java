package com.dit.incidents.controller.request;

import com.dit.incidents.model.request.Request;
import com.dit.incidents.model.response.*;
import com.dit.incidents.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class RequestController {

    @Autowired
    RequestRepository requestRepository;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");


    @GetMapping("/")
    public List<Response12> foo() throws ParseException {


        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Timestamp from = new Timestamp(dateFormat.parse("2000-01-12").getTime());
        Timestamp to = new Timestamp(dateFormat.parse("2019-01-12").getTime());
        Timestamp t1 = new Timestamp(dateFormat.parse("2018-12-13").getTime());
        String givenType = "Abandoned Vehicle Complaint";


//        System.out.println(sdf.format(t1));
//        System.out.println(r.get(0).getClass());
//        return r;
        return  null;
    }
}
