package com.dit.incidents.model.request;

import com.dit.incidents.model.auth.UserReg;
import org.postgis.Point;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;


@Entity(name = "REQUEST")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REQUEST_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_REG_ID", nullable=true)
    private UserReg userReg;


    @Column(name = "CREATION_DATE")
    private Timestamp creationDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "COMPLETION_DATE")
    private Timestamp completionDate;

    @Column(name = "REQUEST_NUMBER")
    private String requestNumber;

    @Column(name = "REQUEST_TYPE")
    private String requestType;

    @Column(name = "STREAT_ADDRESS")
    private String streetAddress;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "WARD")
    private Integer ward;

    @Column(name = "POLICE_DISTRICT")
    private Integer policeDistrict;

    @Column(name = "COMMUINITY_AREA")
    private Integer communityArea;

    @Column(name = "HISTORICA_WARDS")
    private Integer historicalWards;

    @Column(name = "ZIP_CODES")
    private String zipCodes;

    @Column(name = "COMMUNITY_AREAS")
    private Integer communityAreas;

    @Column(name = "CENSUS_TRACTS")
    private Integer censusTracts;

    @Column(name = "WARDS")
    private Integer wards;

    @Column(name = "X_COORDINATE", precision = 13, scale = 3)
    private BigDecimal xCoordinate;

    @Column(name = "Y_COORDINATE", precision = 13, scale = 3)
    private BigDecimal yCoordinate;

    @Column(name = "LATITUDE", precision = 13, scale = 3)
    private BigDecimal latitude;

    @Column(name = "LONGITUDE", precision = 13, scale = 3)
    private Double longitude;

    public Request() {
    }

    public Request(Long id, Timestamp creationDate, String status, Timestamp completionDate, String requestNumber, String requestType, String streetAddress, String zipCode, Integer ward, Integer policeDistrict, Integer communityArea, Integer historicalWards, String zipCodes, Integer communityAreas, Integer censusTracts, Integer wards, BigDecimal xCoordinate, BigDecimal yCoordinate, BigDecimal latitude, Double longitude) {
        this.id = id;
        this.creationDate = creationDate;
        this.status = status;
        this.completionDate = completionDate;
        this.requestNumber = requestNumber;
        this.requestType = requestType;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.ward = ward;
        this.policeDistrict = policeDistrict;
        this.communityArea = communityArea;
        this.historicalWards = historicalWards;
        this.zipCodes = zipCodes;
        this.communityAreas = communityAreas;
        this.censusTracts = censusTracts;
        this.wards = wards;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Request(Timestamp creationDate, String status, Timestamp completionDate, String requestNumber, String requestType, String streetAddress, String zipCode, Integer ward, Integer policeDistrict, Integer communityArea, Integer historicalWards, String zipCodes, Integer communityAreas, Integer censusTracts, Integer wards, BigDecimal xCoordinate, BigDecimal yCoordinate, BigDecimal latitude, Double longitude) {
        this.creationDate = creationDate;
        this.status = status;
        this.completionDate = completionDate;
        this.requestNumber = requestNumber;
        this.requestType = requestType;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.ward = ward;
        this.policeDistrict = policeDistrict;
        this.communityArea = communityArea;
        this.historicalWards = historicalWards;
        this.zipCodes = zipCodes;
        this.communityAreas = communityAreas;
        this.censusTracts = censusTracts;
        this.wards = wards;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Timestamp completionDate) {
        this.completionDate = completionDate;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getWard() {
        return ward;
    }

    public void setWard(Integer ward) {
        this.ward = ward;
    }

    public Integer getPoliceDistrict() {
        return policeDistrict;
    }

    public void setPoliceDistrict(Integer policeDistrict) {
        this.policeDistrict = policeDistrict;
    }

    public Integer getCommunityArea() {
        return communityArea;
    }

    public void setCommunityArea(Integer communityArea) {
        this.communityArea = communityArea;
    }

    public Integer getHistoricalWards() {
        return historicalWards;
    }

    public void setHistoricalWards(Integer historicalWards) {
        this.historicalWards = historicalWards;
    }

    public String getZipCodes() {
        return zipCodes;
    }

    public void setZipCodes(String zipCodes) {
        this.zipCodes = zipCodes;
    }

    public Integer getCommunityAreas() {
        return communityAreas;
    }

    public void setCommunityAreas(Integer communityAreas) {
        this.communityAreas = communityAreas;
    }

    public Integer getCensusTracts() {
        return censusTracts;
    }

    public void setCensusTracts(Integer censusTracts) {
        this.censusTracts = censusTracts;
    }

    public Integer getWards() {
        return wards;
    }

    public void setWards(Integer wards) {
        this.wards = wards;
    }

    public BigDecimal getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(BigDecimal xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public BigDecimal getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(BigDecimal yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public UserReg getUserReg() {
        return userReg;
    }

    public void setUserReg(UserReg userReg) {
        this.userReg = userReg;
    }
}
