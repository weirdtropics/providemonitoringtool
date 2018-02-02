package testrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import testrequest.domain.Monitor;
import testrequest.repo.MonitorRepository;

@Component
public class MonitorExecutor {

    @Autowired
    MonitorRepository repository;

    @Autowired
    UrlChecker urlChecker;

    @Async
    public void executeCheck(Monitor monitor) {
        Monitor.MonitoringStatus status = urlChecker.getStatus(monitor);
        monitor.setStatus(status);

        if (repository.exists(monitor.getId())) {
            repository.save(monitor);
        }
    }
}
