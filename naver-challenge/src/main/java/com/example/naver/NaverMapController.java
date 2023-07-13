package com.example.naver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NaverMapController {
    @GetMapping("map")
    public String map() {
        return "map";
    }
}
