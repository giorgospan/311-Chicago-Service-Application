package com.dit.incidents.response.search_query;

import java.util.Date;

public interface ResponseSearch {
    String getRequestId();
    Date getCreationDate();
    String getRequestType();
}
