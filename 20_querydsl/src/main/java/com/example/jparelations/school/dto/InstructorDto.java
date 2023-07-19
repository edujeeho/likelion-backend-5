package com.example.jparelations.school.dto;

import com.example.jparelations.school.entity.Instructor;
import lombok.Data;

@Data
public class InstructorDto {
    private Long id;
    private String firstName;
    private String lastName;

    public static InstructorDto fromEntity(Instructor entity){
        InstructorDto dto = new InstructorDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }

    public Instructor newEntity() {
        Instructor entity = new Instructor();
        entity.setLastName(lastName);
        entity.setFirstName(firstName);
        return entity;
    }
}
