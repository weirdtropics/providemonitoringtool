package testrequest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import testrequest.app.Application;
import testrequest.domain.Monitor;
import testrequest.repo.MonitorRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static testrequest.domain.Monitor.MonitoringStatus.OK;

@WebMvcTest(MonitoringControllerTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MonitoringControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    MonitorController controller;

    @MockBean
    private MonitorRepository monitorRepositoryMock;

    @Test
    public void shouldReturnAllMonitors() throws Exception {
        Monitor expectedMonitor = new Monitor();
        expectedMonitor.setActive(true);
        expectedMonitor.setStatus(OK);
        expectedMonitor.setExceptedHttpResponseCode(300);
        expectedMonitor.setExpectedResponseSizeFrom(0);
        expectedMonitor.setExpectedResponseSizeTo(10000);

        when(monitorRepositoryMock.findAll()).thenReturn(Arrays.asList(expectedMonitor));
        mockMvc.perform(get("/monitor/all")).andExpect((status().isOk()));
    }

    @Test
    public void shouldReturnOne() throws Exception {
        Monitor expectedMonitor = new Monitor();
        expectedMonitor.setActive(true);
        expectedMonitor.setStatus(OK);
        expectedMonitor.setExceptedHttpResponseCode(300);
        expectedMonitor.setExpectedResponseSizeFrom(0);
        expectedMonitor.setExpectedResponseSizeTo(10000);

        when(monitorRepositoryMock.findOne(0L)).thenReturn(expectedMonitor);
        mockMvc.perform(get("/monitor/{id}", 0)).andExpect((status().isOk()));
    }

    @Configuration
    @ComponentScan(basePackageClasses = { MonitoringControllerTest.class })
    public static class TestConf {}

}


