package com.example.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DirectionResponseDto {
    private List<Point> path;
}
