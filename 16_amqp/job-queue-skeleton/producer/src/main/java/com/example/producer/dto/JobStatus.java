package com.example.producer.dto;

import com.example.producer.jpa.JobEntity;
import lombok.Data;

@Data
public class JobStatus {
    private String jobId;
    private String status;
    private String resultPath;

    public static JobStatus fromEntity(JobEntity entity) {
        JobStatus jobStatus = new JobStatus();
        jobStatus.setJobId(entity.getJobId());
        jobStatus.setStatus(entity.getStatus());
        jobStatus.setResultPath(entity.getResultPath());

        return jobStatus;
    }
}
