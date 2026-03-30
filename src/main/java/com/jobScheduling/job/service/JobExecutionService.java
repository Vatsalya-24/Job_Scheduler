package com.jobScheduling.job.service;

import com.jobScheduling.job.dto.JobExecutionDTO;
import com.jobScheduling.job.entity.ExecutionStatus;
import com.jobScheduling.job.entity.JobExecution;
import com.jobScheduling.job.entity.JobStatus;
import com.jobScheduling.job.entity.Jobs;
import com.jobScheduling.job.repository.JobExecutionRepository;
import com.jobScheduling.job.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobExecutionService {

    private JobExecutionRepository jobExecutionRepository;

    private JobsRepository jobsRepository;


    public JobExecutionService(JobExecutionRepository jobExecutionRepository,  JobsRepository jobsRepository) {
        this.jobExecutionRepository = jobExecutionRepository;
        this.jobsRepository = jobsRepository;
    }

    public JobExecutionDTO getJobExecutionById(JobExecutionDTO dto){

        Jobs jobs = jobsRepository.findById(dto.getJobId()).orElseThrow(() -> new RuntimeException("Job Not Found")) ;
        JobExecution jobExecution = new  JobExecution();

        jobExecution.setStatus(ExecutionStatus.valueOf(dto.getStatus()));
        jobExecution.setStartedAt(dto.getStartedAt());
        jobExecution.setFinishedAt(dto.getFinishedAt());
        jobExecution.setErrorMessage(dto.getErrorMessage());
        jobExecution.setJobs(jobs);

        JobExecution jobExecution1 = jobExecutionRepository.save(jobExecution);

        return mapToDTO(jobExecution1);

    }

    private JobExecutionDTO mapToDTO(JobExecution jobExecution){
        JobExecutionDTO dto = new JobExecutionDTO();
        dto.setId(jobExecution.getId());
        dto.setStatus(jobExecution.getStatus().toString());
        dto.setStartedAt(jobExecution.getStartedAt());
        dto.setFinishedAt(jobExecution.getFinishedAt());
        dto.setErrorMessage(jobExecution.getErrorMessage());
        dto.setJobId(jobExecution.getJobs().getId());
        return dto;
    }
}
