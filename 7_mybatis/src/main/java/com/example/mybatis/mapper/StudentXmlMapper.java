package com.example.mybatis.mapper;

import com.example.mybatis.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentXmlMapper {
    // insert
    void insertStudent(Student student);
    void insertStudentKeys(Student student);

    // select
    List<Student> selectStudentAll();
    Student selectStudent(Long id);

    // update
    void updateStudent(Student student);

    // delete
    void deleteStudent(Long id);

    // select with optional
    Optional<Student> selectStudentOptional(Long id);

    // dynamic sql
    List<Student> findByFields(Student student);
    void insertStudentBatch(List<Student> students);
}
