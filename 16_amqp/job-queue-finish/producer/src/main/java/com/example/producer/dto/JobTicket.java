package com.example.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// 사용자에게 요청의 처리 상태를 확인할 수 있는
// jobId를 반환하는 용도의 DTO
public class JobTicket {
    private String jobId;
}
