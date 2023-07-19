package com.example.jparelations.school.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "enrolling_lectures",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lecture_id")
    )
    private List<Lecture> attending;

    @ManyToOne
    private Instructor advisor;
}
