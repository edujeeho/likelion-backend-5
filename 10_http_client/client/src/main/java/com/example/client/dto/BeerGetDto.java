package com.example.client.dto;

import lombok.Data;

@Data
public class BeerGetDto {
    private Long id;
    private String uid;
    private String brand;
    private String name;
    private String style;
    private String hop;
    private String yeast;
    private String malts;
    private String ibu;
    private String alcohol;
    private String blg;
}
