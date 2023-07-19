package com.example.jparelations.school.repo;

import com.example.jparelations.school.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository
        extends JpaRepository<Lecture, Long>, LectureRepositoryCustom {}
