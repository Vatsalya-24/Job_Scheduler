package com.jobScheduling.job.repository;

import com.jobScheduling.job.entity.JobExecution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetryLogRepository extends JpaRepository<JobExecution, Long> {
}
