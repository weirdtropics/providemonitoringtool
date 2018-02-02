package testrequest.repo;
import testrequest.domain.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface MonitorRepository extends JpaRepository<Monitor, Long> {

    }
