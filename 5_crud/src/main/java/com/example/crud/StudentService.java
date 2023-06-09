package com.example.crud;

import com.example.crud.model.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    // 복수의 StudentDto 를 담는 멤버변수 (필드)
    private final List<StudentDto> studentList = new ArrayList<>();
    private Long nextId = 1L;

    // 새로운 StudentDto 를 생성하는 메소드
    public StudentDto createStudent(String name, String email) {
        StudentDto newStudent = new StudentDto(
                nextId, name, email
        );
        nextId++;
        studentList.add(newStudent);
        return newStudent;
    }

    public List<StudentDto> readStudentAll() {
        return studentList;
    }

    // Service에서 단일 StudentDto를 주는 메소드를 만들겁니다
    // 이때 이 메소드가 받을 인자는 무엇일까요?
    public StudentDto readStudent(Long id) {
        for (StudentDto studentDto: studentList) {
            if (studentDto.getId().equals(id))
                return studentDto;
        }

        return null;

//        return studentList
//                .stream()
//                .filter(studentDto -> studentDto.getId().equals(id))
//                .findFirst()
//                .orElse(null);
    }


}
