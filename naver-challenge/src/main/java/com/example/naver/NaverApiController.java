package com.example.naver;

import com.example.naver.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class NaverApiController {
    private final NaverApiService service;
    @PostMapping("direction")
    public DirectionResponseDto direction(
            @RequestBody DirectionRequestDto requestDto
    ) {
        return service.direction(requestDto);
    }

    @PostMapping("geocoding")
    public GeocodingResponseDto geocoding(
            @RequestBody GeocodingRequestDto requestDto
    ) {
        return service.geocoding(requestDto);
    }
}
