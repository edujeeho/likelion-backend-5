package com.example.jparelations.school.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String firstName;
    @Column(length = 64)
    private String lastName;

    @OneToMany
    @JoinColumn(name = "instructor_id")
    private List<Lecture> lectures;

}
