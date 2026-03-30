package com.jobScheduling.job.repository;

import com.jobScheduling.job.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long> {

}
