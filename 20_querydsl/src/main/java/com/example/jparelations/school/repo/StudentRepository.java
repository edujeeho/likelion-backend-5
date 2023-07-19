package com.example.jparelations.school.repo;

import com.example.jparelations.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}
