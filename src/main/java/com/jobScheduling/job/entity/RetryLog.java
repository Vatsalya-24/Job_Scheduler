package com.jobScheduling.job.entity;

import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
@Table(name = "retry_log")
public class RetryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "execution_id_id")
    private JobExecution executionId;

    private Long attemptNumber;

    private Timestamp firedAt;

    public RetryLog(JobExecution executionId, Long attemptNumber, Timestamp firedAt) {
        this.executionId = executionId;
        this.attemptNumber = attemptNumber;
        this.firedAt = firedAt;
    }

    public RetryLog() {}

    public Long getId() {
        return id;
    }

    public JobExecution getExecutionId() {
        return executionId;
    }

    public void setExecutionId(JobExecution executionId) {
        this.executionId = executionId;
    }

    public Long getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(Long attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public Timestamp getFiredAt() {
        return firedAt;
    }

    public void setFiredAt(Timestamp firedAt) {
        this.firedAt = firedAt;
    }

    @Override
    public String toString() {
        return "retryLog{" +
                "id=" + id +
                ", executionId=" + executionId +
                ", attemptNumber=" + attemptNumber +
                ", firedAt=" + firedAt +
                '}';
    }
}
