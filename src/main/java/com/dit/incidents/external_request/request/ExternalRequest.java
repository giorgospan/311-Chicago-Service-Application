package com.dit.incidents.external_request.request;

import com.dit.incidents.enums.RequestType;

import java.math.BigDecimal;

public class ExternalRequest {

    protected String status;

    protected String requestNumber;

    protected String requestType;

    protected String streetAddress;

    protected String zipCode;

    protected Integer ward;

    protected Integer policeDistrict;

    protected Integer communityArea;

    protected Integer historicalWards;

    protected String zipCodes;

    protected Integer communityAreas;

    protected Integer censusTracts;

    protected Integer wards;

    protected BigDecimal xCoordinate;

    protected BigDecimal yCoordinate;

    protected BigDecimal latitude;

    protected BigDecimal longitude;

    protected RequestType enumRequestType;

    public ExternalRequest() {
    }

    public ExternalRequest(String status, String requestNumber, String requestType, String streetAddress, String zipCode, Integer ward, Integer policeDistrict, Integer communityArea, Integer historicalWards, String zipCodes, Integer communityAreas, Integer censusTracts, Integer wards, BigDecimal xCoordinate, BigDecimal yCoordinate, BigDecimal latitude, BigDecimal longitude, RequestType enumRequestType) {
        this.status = status;
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
        this.enumRequestType = enumRequestType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public RequestType getEnumRequestType() {
        return enumRequestType;
    }

    public void setEnumRequestType(RequestType enumRequestType) {
        this.enumRequestType = enumRequestType;
    }
}
