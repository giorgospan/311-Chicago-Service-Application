package com.dit.incidents.model;

import org.postgis.Point;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    private Timestamp creationDate;
    private String status;
    private Timestamp completionDate;
    private String requestNumber;
    private String requestType;
    private String streetAddress;
    private String zipCode;
    private Short ward;
    private Short policeDistrict;
    private Short communityArea;
    private Short historicalWards;
    private String zipCodes;
    private Short communityAreas;
    private Short censusTracts;
    private Short wards;
    private Double xCoordinate;
    private Double yCoordinate;
    private Double latitude;
    private Double longitude;

}
