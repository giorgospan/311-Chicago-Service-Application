package com.dit.incidents.model.request;

import com.dit.incidents.external_request.request.ExternalRequest;
import com.dit.incidents.model.auth.UserReg;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "REQUEST")
public class Request {

    @Id
    @GenericGenerator(name = "db_gen" , strategy = "increment")
    @GeneratedValue(generator = "db_gen")
    @Column(name = "REQUEST_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_REG_ID", nullable = true)
    private UserReg userReg;

    @Column(name = "CREATION_DATE", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    private Timestamp creationDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "COMPLETION_DATE")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp completionDate;

    @Column(name = "REQUEST_NUMBER")
    private String requestNumber;

    @Column(name = "REQUEST_TYPE")
    private String requestType;

    @Column(name = "STREET_ADDRESS")
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

    @Column(name = "X_COORDINATE", precision = 20, scale = 9)
    private BigDecimal xCoordinate;

    @Column(name = "Y_COORDINATE", precision = 20, scale = 9)
    private BigDecimal yCoordinate;

    @Column(name = "LATITUDE", precision = 18, scale = 14)
    private BigDecimal latitude;

    @Column(name = "LONGITUDE", precision = 18, scale = 14)
    private BigDecimal longitude;

    public Request() {
    }

    public Request(Long id, Timestamp creationDate, String status, Timestamp completionDate, String requestNumber, String requestType, String streetAddress, String zipCode, Integer ward, Integer policeDistrict, Integer communityArea, Integer historicalWards, String zipCodes, Integer communityAreas, Integer censusTracts, Integer wards, BigDecimal xCoordinate, BigDecimal yCoordinate, BigDecimal latitude, BigDecimal longitude) {
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

    public Request(Timestamp creationDate, String status, Timestamp completionDate, String requestNumber, String requestType, String streetAddress, String zipCode, Integer ward, Integer policeDistrict, Integer communityArea, Integer historicalWards, String zipCodes, Integer communityAreas, Integer censusTracts, Integer wards, BigDecimal xCoordinate, BigDecimal yCoordinate, BigDecimal latitude, BigDecimal longitude) {
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

    public Request(ExternalRequest externalRequest) {
        this.status = externalRequest.getStatus();
        this.requestNumber = externalRequest.getRequestNumber();
        this.requestType = externalRequest.getRequestType();
        this.streetAddress = externalRequest.getStreetAddress();
        this.zipCode = externalRequest.getZipCode();
        this.ward = externalRequest.getWard();
        this.policeDistrict = externalRequest.getPoliceDistrict();
        this.communityArea = externalRequest.getCommunityArea();
        this.historicalWards = externalRequest.getHistoricalWards();
        this.zipCodes = externalRequest.getZipCodes();
        this.communityAreas = externalRequest.getCommunityAreas();
        this.censusTracts = externalRequest.getCensusTracts();
        this.wards = externalRequest.getWards();
        this.xCoordinate = externalRequest.getxCoordinate();
        this.yCoordinate = externalRequest.getyCoordinate();
        this.latitude = externalRequest.getLatitude();
        this.longitude = externalRequest.getLongitude();
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

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public UserReg getUserReg() {
        return userReg;
    }

    public void setUserReg(UserReg userReg) {
        this.userReg = userReg;
    }
}
