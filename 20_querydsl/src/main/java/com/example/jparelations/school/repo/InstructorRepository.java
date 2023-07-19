package com.example.jparelations.school.repo;

import com.example.jparelations.school.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {}
