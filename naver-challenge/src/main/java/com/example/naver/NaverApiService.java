package com.example.naver;

import com.example.naver.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NaverApiService {
    public DirectionResponseDto direction(DirectionRequestDto requestDto) {
        List<Point> path = new ArrayList<>();
        path.add(new Point(requestDto.getStart().getLat(), requestDto.getStart().getLng()));
        path.add(new Point(requestDto.getGoal().getLat(), requestDto.getGoal().getLng()));
        return new DirectionResponseDto(path);
    }

    public GeocodingResponseDto geocoding(GeocodingRequestDto requestDto) {
        return new GeocodingResponseDto("서울특별시 종로구 종로3길 17");
    }
}
