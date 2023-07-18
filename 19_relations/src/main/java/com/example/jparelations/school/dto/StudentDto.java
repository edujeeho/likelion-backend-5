package com.example.jparelations.school.dto;

import com.example.jparelations.school.entity.Student;
import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;

    public static StudentDto fromEntity(Student entity) {
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }

    public Student newEntity() {
        Student entity = new Student();
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        return entity;
    }
}
