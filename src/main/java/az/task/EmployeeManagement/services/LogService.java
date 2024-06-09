package az.task.EmployeeManagement.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogService.class);

    public void doSomething() {
        LOGGER.info("log message=-====---=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=---------------------------------------" +
                "-=-=-=-=-=-=-=-=-=-=-==-=-=-=");
    }
}
