package com.example.jpa.entities;
/* CREATE TABLE students (
*   id INTEGER PRIMARY KEY AUTOINCREMENT,
*   name TEXT,
*   age INTEGER,
*   phone TEXT,
*   email TEXT
* */

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity  // 데이터베이스 테이블의 레코드임을 나타냄
// 테이블에 지정하고 싶은 설정 (이름이라던지)
@Table(name = "students")
public class StudentEntity {  // student_entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Column 어노테이션에 인자를 전달해서 테이블 Constraint 추가 가능
    // @Column(name = "username", nullable = false)
    private String name;
    private Integer age;
    // @Column(unique = true)
    private String phone;
    private String email;
}

