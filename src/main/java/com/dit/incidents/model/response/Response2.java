package com.dit.incidents.model.response;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import java.util.Date;

public interface Response2 {

    Integer getTotalRequests();
    Date getDay();
}
