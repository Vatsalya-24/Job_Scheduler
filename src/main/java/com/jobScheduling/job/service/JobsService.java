package com.jobScheduling.job.service;

import com.jobScheduling.job.entity.JobStatus;
import com.jobScheduling.job.entity.Jobs;
import com.jobScheduling.job.repository.JobExecutionRepository;
import com.jobScheduling.job.repository.JobsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class JobsService{

    @Autowired
    private JobsRespository jobsRespository;

    public JobsService(JobsRespository  jobsRespository) {
        this.jobsRespository = jobsRespository;
    }

    public String createNewJob(String name, String cronExpression, String target, Timestamp nextFireTime){
        CronExpression cron;
        try {
            cron = CronExpression.parse(cronExpression);
        } catch (Exception e) {
            return "Invalid cron expression";
        }

        Jobs job = new Jobs();
        job.setName(name);
        job.setCronExpression(cronExpression);
        job.setTarget(target);
        job.setStatus(JobStatus.ACTIVE);
        job.setNextFireTime(nextFireTime);

        jobsRespository.save(job);

        return "Job Created with job id" + job.getId() + "with name " + name + " and target " + target;

    }

}
