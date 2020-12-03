package com.dit.incidents.model.log;

import com.dit.incidents.enums.LogQueryType;
import com.dit.incidents.model.auth.UserReg;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "LOG")
public class Log {

    /*
     * Primary key is auto-generated, on insert
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_ID")
    private Long id;

    @Column(name = "LOG_DATE", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    private Timestamp logDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_REG_ID", nullable = true)
    private UserReg userReg;

    @Column(name = "QUERY_TYPE")
    private LogQueryType queryType;

    @Column(name = "QUERY_PARAMETERS", columnDefinition = "TEXT")
    private String queryParameters;

    public Log() {
    }

    public Log(Long id, Timestamp logDate, UserReg userReg, LogQueryType queryType, String queryParameters) {
        this.id = id;
        this.logDate = logDate;
        this.userReg = userReg;
        this.queryType = queryType;
        this.queryParameters = queryParameters;
    }

    public Log(Timestamp logDate, UserReg userReg, LogQueryType queryType, String queryParameters) {
        this.logDate = logDate;
        this.userReg = userReg;
        this.queryType = queryType;
        this.queryParameters = queryParameters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getLogDate() {
        return logDate;
    }

    public void setLogDate(Timestamp logDate) {
        this.logDate = logDate;
    }

    public UserReg getUserReg() {
        return userReg;
    }

    public void setUserReg(UserReg userReg) {
        this.userReg = userReg;
    }

    public LogQueryType getQueryType() {
        return queryType;
    }

    public void setQueryType(LogQueryType queryType) {
        this.queryType = queryType;
    }

    public String getQueryParameters() {
        return queryParameters;
    }

    public void setQueryParameters(String queryParameters) {
        this.queryParameters = queryParameters;
    }
}
