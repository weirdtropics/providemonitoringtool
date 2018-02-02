package testrequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import testrequest.domain.Monitor;

import static testrequest.domain.Monitor.MonitoringStatus.CRITICAL;
import static testrequest.domain.Monitor.MonitoringStatus.OK;

@Component
public class UrlChecker {

    public Monitor.MonitoringStatus getStatus(Monitor monitor) {

        HttpClient client = HttpClientBuilder.create().build();
        Monitor.MonitoringStatus status;

        try {
            HttpGet request = new HttpGet(monitor.getUrl());
            HttpResponse response = client.execute(request);

            status = OK;
            if (response.getStatusLine().getStatusCode() != monitor.getExceptedHttpResponseCode()) {
                status = CRITICAL;

            }

           int responseSize  = EntityUtils.toByteArray(response.getEntity()).length;

            if (!(responseSize > monitor.getExpectedResponseSizeFrom() &&
                    responseSize < monitor.getExpectedResponseSizeTo())) {

                status = CRITICAL;
            }

        } catch (Exception e) {
            e.printStackTrace();
            status = CRITICAL;
        }

        return status;

    }

}
