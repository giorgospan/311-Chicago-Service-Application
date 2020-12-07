package com.dit.incidents.log_utils;

import java.util.Date;

// Note: this implementation is not the best, we can do it dynamically and adaptive
public class ConstructQueryParameters {

    static final String LEFT_DELIM = "{";
    static final String RIGHT_DELIM = "}";
    static final String PARAMS_SPLITTER = "|";

    static final String GIVEN_TYPE = "requestType:";
    static final String FROM = "fromTm:";
    static final String TO = "toTm:";
    static final String TARGET = "targetTm:";
    static final String X_MIN = "xMin:";
    static final String Y_MIN = "yMin:";
    static final String X_MAX = "xMax:";
    static final String Y_MAX = "yMax:";
    static final String NONE = "none";
    static final String TARGET_NUM = "targetNum:";
    static final String ZIP_CODE = "zipCode:";
    static final String STREET_ADDRESS = "streetAddress:";

    public static String constructParamsQuery1(Date from, Date to) {
        return LEFT_DELIM + FROM + from.toString() + PARAMS_SPLITTER + TO + to.toString() + RIGHT_DELIM;
    }

    public static String constructParamsQuery2(String givenType, Date from, Date to) {
        return LEFT_DELIM + GIVEN_TYPE + givenType + PARAMS_SPLITTER + FROM + from.toString() + PARAMS_SPLITTER + TO + to.toString() + RIGHT_DELIM;
    }

    public static String constructParamsQuery3(Date targetTm) {
        return LEFT_DELIM + TARGET + targetTm.toString() + RIGHT_DELIM;
    }

    public static String constructParamsQuery4(Date from, Date to) {
        return LEFT_DELIM + FROM + from.toString() + PARAMS_SPLITTER + TO + to.toString() + RIGHT_DELIM;
    }

    public static String constructParamsQuery5(Double xMin, Double yMin, Double xMax, Double yMax, Date targetTm) {
        return LEFT_DELIM + X_MIN + xMin.toString() + PARAMS_SPLITTER + Y_MIN + yMin.toString() + PARAMS_SPLITTER + X_MAX + xMax.toString() +
                PARAMS_SPLITTER + Y_MAX + yMax.toString() + PARAMS_SPLITTER + TARGET + targetTm.toString() + RIGHT_DELIM;
    }

    public static String constructParamsQuery6(Date from, Date to) {
        return LEFT_DELIM + FROM + from.toString() + PARAMS_SPLITTER + TO + to.toString() + RIGHT_DELIM;
    }

    public static String constructParamsQuery7() {
        return LEFT_DELIM + NONE + RIGHT_DELIM;
    }

    public static String constructParamsQuery8() {
        return LEFT_DELIM + NONE + RIGHT_DELIM;
    }

    public static String constructParamsQuery9(Integer targetNum) {
        return LEFT_DELIM + TARGET_NUM + targetNum.toString() + RIGHT_DELIM;
    }

    public static String constructParamsQuery10(Integer targetNum) {
        return LEFT_DELIM + TARGET_NUM + targetNum.toString() + RIGHT_DELIM;
    }

    public static String constructParamsQuery11(Integer targetNum) {
        return LEFT_DELIM + TARGET_NUM + targetNum.toString() + RIGHT_DELIM;
    }

    public static String constructParamsQuery12(Date targetTm) {
        return LEFT_DELIM + TARGET + targetTm.toString() + RIGHT_DELIM;
    }

    public static String constructParamsInsert() {
        return LEFT_DELIM + "insertion object here" + RIGHT_DELIM;
    }

    public static String constructParamsUpdate() {
        return LEFT_DELIM + "update object here" + RIGHT_DELIM;
    }

    public static String constructParamsQueryZipCode(String zipCode) {
        return LEFT_DELIM + ZIP_CODE + zipCode + RIGHT_DELIM;
    }

    public static String constructParamsQueryStreetAddress(String streetAddress) {
        return LEFT_DELIM + STREET_ADDRESS + streetAddress + RIGHT_DELIM;
    }
}
