package com.jobScheduling.job.service;

import com.jobScheduling.job.dto.JobsDTO;
import com.jobScheduling.job.entity.JobStatus;
import com.jobScheduling.job.entity.Jobs;
import com.jobScheduling.job.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.stereotype.Service;

@Service
public class JobsService{

    @Autowired
    private final JobsRepository jobsRepository;

    public JobsService(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    public JobsDTO createNewJob(JobsDTO dto){

        CronExpression cron = CronExpression.parse(dto.getCronExpression());
        Jobs jobs = new Jobs();
        jobs.setName(dto.getName());
        jobs.setCronExpression(dto.getCronExpression());
        jobs.setTarget(dto.getTarget());
        jobs.setStatus(JobStatus.valueOf(dto.getStatus()));
        jobs.setNextFireTime(dto.getNextFireTime());
        Jobs job = jobsRepository.save(jobs);

        return mapToDTO(job);

    }

    private JobsDTO mapToDTO(Jobs jobs){
        JobsDTO dto = new JobsDTO();
        dto.setId(jobs.getId());
        dto.setName(jobs.getName());
        dto.setCronExpression(jobs.getCronExpression());
        dto.setTarget(jobs.getTarget());
        dto.setStatus(jobs.getStatus().name());
        dto.setNextFireTime(jobs.getNextFireTime());
        return dto;
    }

}
