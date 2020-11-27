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
    private Integer ward;
    private Integer policeDistrict;
    private Integer communityArea;
    private Integer historicalWards;
    private String zipCodes;
    private Integer communityAreas;
    private Integer censusTracts;
    private Integer wards;
    private Double xCoordinate;
    private Double yCoordinate;
    private Double latitude;
    private Double longitude;

}
