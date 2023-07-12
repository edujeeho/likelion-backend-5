package com.example.producer.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "jobs")
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 작업을 식별하기 위한 ID (UUID)
    private String jobId;
    // 작업의 상태를 저장하기 위한 status
    // IDLE: 아직 처리 시작 전
    // PROCESSING: 어떤 Consumer에 의해 작업이 처리되기 사작
    // DONE: 작업 처리 끝
    private String status;
    // 인코딩이 끝난 영상이 위치할 곳 (가정)
    private String resultPath;
}
