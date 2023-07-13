package com.example.naver.dto;

import lombok.Data;

@Data
public class DirectionRequestDto {
    private Point start;
    private Point goal;
}
