package com.example.beer;

import lombok.Data;

@Data
public class BeerDto {
    private String name;
    private Long cc;
    private Double alcohol;
}
