package testrequest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import testrequest.domain.Monitor;
import testrequest.repo.MonitorRepository;

import java.util.List;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @Autowired
    private MonitorRepository monitorRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Monitor getMonitor(@PathVariable("id") Long id) {
        return monitorRepository.findOne(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public void addMonitor(@RequestBody Monitor monitor) {
        monitorRepository.save(monitor);
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Monitor> getAllMonitors() {
        return monitorRepository.findAll();
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteMonitor(@PathVariable("id") Long id) {
        monitorRepository.delete(id);

    }

    @RequestMapping(value = "/active/{id}", method = RequestMethod.POST)
    public void active(@PathVariable("id") Long id) {
        Monitor monitor = monitorRepository.findOne(id);
        monitor.setActive(true);
        monitorRepository.save(monitor);
    }
    
    @RequestMapping(value = "/deactive/{id}", method = RequestMethod.POST)
    public void deactive(@PathVariable("id") Long id) {
        Monitor monitor = monitorRepository.findOne(id);
        monitor.setActive(false);
        monitorRepository.save(monitor);
    }


}
