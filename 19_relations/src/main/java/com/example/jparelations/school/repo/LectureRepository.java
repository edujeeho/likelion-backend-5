package com.example.jparelations.school.repo;

import com.example.jparelations.school.entity.Instructor;
import com.example.jparelations.school.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {}
