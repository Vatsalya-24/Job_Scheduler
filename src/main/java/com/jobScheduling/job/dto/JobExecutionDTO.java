
package com.jobScheduling.job.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public class JobExecutionDTO {

    private int id;

    @NotBlank
    private String status;

    @NotBlank
    private Timestamp startedAt;

    @NotBlank
    private Timestamp finishedAt;

    @NotBlank
    private String errorMessage;

    private Long jobId;

    public JobExecutionDTO() {};

    public JobExecutionDTO(int id, String errorMessage, Long jobId, Timestamp finishedAt, Timestamp startedAt, String status) {
        this.id = id;
        this.errorMessage = errorMessage;
        this.jobId = jobId;
        this.finishedAt = finishedAt;
        this.startedAt = startedAt;
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Timestamp getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Timestamp finishedAt) {
        this.finishedAt = finishedAt;
    }

    public Timestamp getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Timestamp startedAt) {
        this.startedAt = startedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

