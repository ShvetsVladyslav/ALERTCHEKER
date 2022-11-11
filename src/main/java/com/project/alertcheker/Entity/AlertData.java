package com.project.alertcheker.Entity;

import javax.persistence.*;

@Entity
@Table(name = "t_alerts")
public class AlertData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "alertUrl", nullable = false)
    private String alertUrl;
    @Column(name = "isCritical", nullable = false)
    private boolean isCritical;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlertUrl() {
        return alertUrl;
    }

    public void setAlertUrl(String alertUrl) {
        this.alertUrl = alertUrl;
    }

    public boolean isCritical() {
        return isCritical;
    }

    public void setCritical(boolean critical) {
        isCritical = critical;
    }

    public AlertData(String alertUrl, boolean isCritical) {
        this.alertUrl = alertUrl;
        this.isCritical = isCritical;
    }

    public AlertData() {
    }
}