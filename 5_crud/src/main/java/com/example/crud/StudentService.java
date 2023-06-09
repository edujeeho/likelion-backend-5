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

    public StudentService(){
        createStudent("alex", "alex@gmail.com");
        createStudent("brad", "brad@gmail.com");
        createStudent("chad", "chad@gmail.com");
    }

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

    // 단일 StudentDto를 주는 메소드
    public StudentDto readStudent(Long id) {
        for (StudentDto studentDto: studentList) {
            if (studentDto.getId().equals(id))
                return studentDto;
        }

        return null;
    }

    // 어떤 학생 데이터를 갱신할 것인지
    // 그 학생의 갱신될 데이터
    public StudentDto updateStudent(Long id, String name, String email){
        StudentDto targetDto = this.readStudent(id);
        if (targetDto != null) {
            targetDto.setName(name);
            targetDto.setEmail(email);
            return targetDto;
        } else return null;

    }
}















