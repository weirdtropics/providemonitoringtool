package testrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import testrequest.domain.Monitor;
import testrequest.repo.MonitorRepository;

import java.util.List;

@Component
public class MonitoringScheduler {


    @Autowired
    private MonitorExecutor monitorExecutor;


    @Autowired
    MonitorRepository repository;


    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        List<Monitor> tasks = repository.findAll();

        for (Monitor monitor : tasks) {
            if (monitor.isActive()) {
                monitorExecutor.executeCheck(monitor);
            }
        }

    }


}

