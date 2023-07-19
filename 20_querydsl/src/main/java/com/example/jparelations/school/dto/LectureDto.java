package com.example.jparelations.school.dto;

import com.example.jparelations.school.entity.Lecture;
import lombok.Data;

@Data
public class LectureDto {
    private Long id;
    private String name;
    private String day;
    private Integer startTime;
    private Integer endTime;

    public static LectureDto fromEntity(Lecture entity) {
        LectureDto dto = new LectureDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDay(entity.getDay());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        return dto;
    }

    public Lecture newEntity() {
        Lecture entity = new Lecture();
        entity.setName(name);
        entity.setDay(day);
        entity.setStartTime(startTime);
        entity.setEndTime(endTime);
        return entity;
    }
}
