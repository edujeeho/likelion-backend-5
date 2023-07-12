package com.example.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobPayload {
    private String jobId;
    private String filename;
    private String path;
}
