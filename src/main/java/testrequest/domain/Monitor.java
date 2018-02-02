package testrequest.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "monitor")
public class Monitor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, name = "expectedResponseSizeFrom")
    private Integer expectedResponseSizeFrom;

    @Column(nullable = false, name = "expectedResponseSizeTo")
    private Integer expectedResponseSizeTo;


    @Column(name = "url")
    private String url;

    @Column(nullable = false, name = "exceptedHttpResponseCode")
    private Integer exceptedHttpResponseCode;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private MonitoringStatus status = MonitoringStatus.STARTING;

    @Column(name = "active")
    private boolean active = true;


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public Long getId() {
        return id;
    }


    public String getUrl() {
        return url;
    }


    public void setExceptedHttpResponseCode(Integer exceptedHttpResponseCode) {
        this.exceptedHttpResponseCode = exceptedHttpResponseCode;
    }

    public void setExpectedResponseSizeFrom(Integer expectedResponseSizeFrom) {
        this.expectedResponseSizeFrom = expectedResponseSizeFrom;
    }

    public void setExpectedResponseSizeTo(Integer expectedResponseSizeTo) {
        this.expectedResponseSizeTo = expectedResponseSizeTo;
    }

    public int getExceptedHttpResponseCode() {
        return exceptedHttpResponseCode;
    }


    public int getExpectedResponseSizeFrom() {
        return expectedResponseSizeFrom;
    }


    public int getExpectedResponseSizeTo() {
        return expectedResponseSizeTo;
    }

    public MonitoringStatus getStatus() {
        return status;
    }

    public void setStatus(MonitoringStatus status) {

        this.status = status;
    }

    public enum MonitoringStatus {
        STARTING,
        OK,
        WARNING,
        CRITICAL;

    }


}
