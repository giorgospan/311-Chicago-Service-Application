package com.dit.incidents;

import com.dit.incidents.model.request.Request;
import com.dit.incidents.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
public class ChicagoIncidentsApplication implements CommandLineRunner {

    @Autowired
    RequestRepository requestRepository;

    public static void main(String[] args) {
        SpringApplication.run(ChicagoIncidentsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Testing query 1 [Note that dates in our DB are stored with format "yyyy-mm-dd"]
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//        Timestamp from = new Timestamp(dateFormat.parse("2018-12-12").getTime());
//        Timestamp to = new Timestamp(dateFormat.parse("2019-12-12").getTime());
//        List<Request> results =  requestRepository.findAllByCreationDateBetweenOrderByCreationDateDesc(from,to);
//
//        System.out.println("Returned " + results.size() + " results between " + from.toString() + " and " + to.toString());

    }
}
