package com.example.http.dto;

import lombok.Data;

// 일반적인 응답
// 상태
// 메시지
/*
{
   "status": 200,
   "message": "success"
}
 */
@Data
public class ResponseDto {
    private Integer status;
    private String message;
}
