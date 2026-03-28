package com.jobScheduling.job.dto;


import com.jobScheduling.job.config.ValidCron;
import org.jspecify.annotations.NonNull;
import jakarta.validation.constraints.*;
import java.sql.Timestamp;

public class JobsDTO {

    private Long id;

    @NotNull(message = "Job name is required")
    @Size(max = 20)
    private String name;

    @NotNull(message = "Cron Expression is Required")
    @ValidCron
    private String cronExpression;

    @NotBlank
    private String status;

    @NotBlank
    @NotNull(message = "target is Required")
    private String target;

    @NotBlank
    private Timestamp createdAt;

    @NotBlank
    private Timestamp nextFireTime;

    public JobsDTO() {};
    public JobsDTO(Long id, String name, String cronExpression, String status, String target, Timestamp createdAt, Timestamp nextFireTime) {
        this.id = id;
        this.name = name;
        this.cronExpression = cronExpression;
        this.status = status;
        this.target = target;
        this.createdAt = createdAt;
        this.nextFireTime = nextFireTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public String getStatus() {
        return status;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Timestamp getNextFireTime() {
        return nextFireTime;
    }


}
