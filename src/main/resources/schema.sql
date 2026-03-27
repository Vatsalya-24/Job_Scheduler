CREATE TABLE jobs (
                      id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,

                      name VARCHAR(255) NOT NULL,
                      cron_expression VARCHAR(255) NOT NULL,
                      target VARCHAR(255) NOT NULL,

                      status VARCHAR(20) NOT NULL CHECK (
                          status IN ('ACTIVE','PAUSED','DISABLED')
                          ),

                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      next_fire_time TIMESTAMP
);

CREATE TABLE job_executions (
                                id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,

                                job_id BIGINT NOT NULL,

                                status VARCHAR(20) NOT NULL CHECK (
                                    status IN ('STARTED','SUCCESS','FAILED','TIMEOUT')
                                    ),

                                started_at TIMESTAMP,
                                finished_at TIMESTAMP,

                                error_message TEXT,

                                FOREIGN KEY (job_id)
                                    REFERENCES jobs(id)
                                    ON DELETE CASCADE
);

CREATE TABLE retry_log (
                           id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,

                           execution_id BIGINT NOT NULL,
                           attempt_number INT NOT NULL,
                           fired_at TIMESTAMP,

                           FOREIGN KEY (execution_id)
                               REFERENCES job_executions(id)
                               ON DELETE CASCADE
);


CREATE INDEX idx_jobs_next_fire_time ON jobs(next_fire_time);
CREATE INDEX idx_jobs_status_fire_time ON jobs(status, next_fire_time);
CREATE INDEX idx_job_executions_job_id ON job_executions(job_id);