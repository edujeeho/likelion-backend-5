package com.example.jpa.repos;

import com.example.jpa.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// 데이터베이스와 소통하기 위한 창구
public interface StudentRepository
        // JpaRepository<내가 사용할 Entity, 그 Entity의 ID 컬럼의 타입>
        extends JpaRepository<StudentEntity, Long> {

    // Spring Data JPA - Query Method
    // 메소드 이름을 우리가 조회하고 싶은 조건을 붙여서 만든다.
    // 하나 또는 많이
    // (findBy || findAllBy) + [(Column + 조건) * n] + [OrderBy + Column]
    // SELECT * FROM students ORDER BY name
    List<StudentEntity> findAllByOrderByName();

    // SELECT * FROM students ORDER BY age DESC;
    List<StudentEntity> findAllByOrderByAgeDesc();

    // SELECT * FROM Students WHERE age < 21;
    List<StudentEntity> findAllByAgeLessThan(Integer age);

    // SELECT * FROM students WHERE phone LIKE '010-%'
    List<StudentEntity> findAllByPhoneStartingWith(String phone);

}







