package com.example.student;

import com.example.student.dto.StudentDto;
import com.example.student.entity.StudentEntity;
import com.example.student.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public StudentDto createStudent(StudentDto dto) {
        StudentEntity newStudent = new StudentEntity();
        newStudent.setName(dto.getName());
        newStudent.setAge(dto.getAge());
        newStudent.setPhone(dto.getPhone());
        newStudent.setEmail(dto.getEmail());
        this.repository.save(newStudent);
        return StudentDto.fromEntity(newStudent);
    }

    // READ
    public StudentDto readStudent(Long id) {
        Optional<StudentEntity> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            return StudentDto.fromEntity(optionalEntity.get());
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    // READ ALL
    public List<StudentDto> readStudentAll() {
        // 모든 entity 조회 repository method
        List<StudentDto> studentDtoList = new ArrayList<>();
        List<StudentEntity> studentEntityList = this.repository.findAll();
        for (StudentEntity entity : studentEntityList) {
            studentDtoList.add(StudentDto.fromEntity(entity));
        }
        return studentDtoList;
    }

    // UPDATE
    public StudentDto updateStudent(Long id, StudentDto dto) {
        Optional<StudentEntity> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            StudentEntity targetEntity = optionalEntity.get();
            targetEntity.setName(dto.getName());
            targetEntity.setAge(dto.getAge());
            targetEntity.setPhone(dto.getPhone());
            targetEntity.setEmail(dto.getEmail());
            return StudentDto.fromEntity(repository.save(targetEntity));
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    // DELETE
    public void deleteStudent(Long id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
