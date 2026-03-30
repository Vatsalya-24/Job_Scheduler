package com.jobScheduling.job.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String cronExpression;

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    @NotNull
    private String target;

    @NotNull
    @Column(updatable = false)
    private Timestamp createdAt;

    private Timestamp nextFireTime;

    public Jobs(String name, String cronExpression,JobStatus status, String target, Timestamp nextFireTime) {
        this.name = name;
        this.cronExpression = cronExpression;
        this.target = target;
        this.status = status;
        this.nextFireTime = nextFireTime;
    }

    public Jobs() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public JobStatus getStatus() {
        return status;
    }

    public JobStatus setStatus(JobStatus status) {
        return JobStatus.ACTIVE;
    }

    public Timestamp getCreatedAt() {
        this.createdAt = Timestamp.from(Instant.now());
        return createdAt;
    }

    public Timestamp getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(Timestamp nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    @Override
    public String toString() {
        return "jobs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", target='" + target + '\'' +
                ", createdAt=" + createdAt +
                ", nextFireTime=" + nextFireTime +
                '}';
    }
}
