package com.jobScheduling.job.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "job_executions")
public class JobExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private ExecutionStatus status;

    private Timestamp startedAt;

    private Timestamp finishedAt;

    private String errorMessage;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    public JobExecution(ExecutionStatus status, Timestamp startedAt, Timestamp finishedAt, String errorMessage, Jobs jobs) {
        this.status = status;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.errorMessage = errorMessage;
        this.jobs = jobs;
    }

    public JobExecution() {}

    public int getId() {
        return id;
    }

    public ExecutionStatus getStatus() {
        return status;
    }

    public void setStatus(ExecutionStatus status) {
        this.status = status;
    }

    public Timestamp getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Timestamp startedAt) {
        this.startedAt = startedAt;
    }

    public Timestamp getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Timestamp finishedAt) {
        this.finishedAt = finishedAt;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public Jobs getJobs() {
        return jobs;
    }

    @Override
    public String toString() {
        return "jobExecution{" +
                "id=" + id +
                ", status=" + status +
                ", startedAt=" + startedAt +
                ", finishedAt=" + finishedAt +
                ", errorMessage='" + errorMessage + '\'' +
                ", job_id=" + jobs.getId()+
                '}';
    }
}
