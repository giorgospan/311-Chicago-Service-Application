package com.dit.incidents.service.log;

import com.dit.incidents.enums.LogQueryType;
import com.dit.incidents.model.auth.UserReg;
import com.dit.incidents.model.log.Log;
import com.dit.incidents.repository.log.LogRepository;
import com.dit.incidents.service.auth.UserRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private UserRegService userRegService;

    public void insertLog(Long userRegId, LogQueryType queryType, String queryParams) {
        UserReg userReg = userRegService.findById(userRegId);
        Log log = new Log(userReg, queryType, queryParams);
        logRepository.save(log);
    }

}
