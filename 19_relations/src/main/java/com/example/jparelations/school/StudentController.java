package com.example.jparelations.school;

import com.example.jparelations.school.repo.LectureRepository;
import com.example.jparelations.school.repo.StudentRepository;
import com.example.jparelations.school.dto.LectureDto;
import com.example.jparelations.school.dto.StudentDto;
import com.example.jparelations.school.entity.Lecture;
import com.example.jparelations.school.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        return StudentDto.fromEntity(studentRepository.save(studentDto.newEntity()));
    }

    @GetMapping
    public List<StudentDto> readStudentsAll() {
        List<StudentDto> studentList = new ArrayList<>();
        for (Student student: studentRepository.findAll())
            studentList.add(StudentDto.fromEntity(student));

        return studentList;
    }

    @GetMapping("{id}")
    public StudentDto readStudent(@PathVariable("id") Long id) {
        Optional<Student> optionalStudent
                = studentRepository.findById(id);
        if (optionalStudent.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return StudentDto.fromEntity(optionalStudent.get());
    }

    @GetMapping("{id}/lectures")
    public List<LectureDto> readStudentLectures(
            @PathVariable("id") Long id
    ) {
        Optional<Student> optionalStudent
                = studentRepository.findById(id);
        if (optionalStudent.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        List<LectureDto> lectureList = new ArrayList<>();
        for (Lecture lecture: optionalStudent.get().getAttending()) {
            lectureList.add(LectureDto.fromEntity(lecture));
        }
        return lectureList;
    }

    @PutMapping("{id}/lectures/{lectureId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudentLectures(
            @PathVariable("id") Long id,
            @PathVariable("lectureId") Long lectureId
    ) {
        Optional<Student> optionalStudent
                = studentRepository.findById(id);
        if (optionalStudent.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Optional<Lecture> optionalLecture
                = lectureRepository.findById(lectureId);
        if (optionalLecture.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Student student = optionalStudent.get();
        Lecture lecture = optionalLecture.get();

        student.getAttending().add(lecture);
        studentRepository.save(student);
    }

    @DeleteMapping("{id}/lectures/{lectureId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentLectures(
            @PathVariable("id") Long id,
            @PathVariable("lectureId") Long lectureId
    ) {
        Optional<Student> optionalStudent
                = studentRepository.findById(id);
        if (optionalStudent.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Optional<Lecture> optionalLecture
                = lectureRepository.findById(lectureId);
        if (optionalLecture.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Student student = optionalStudent.get();
        Lecture lecture = optionalLecture.get();

        student.getAttending().remove(lecture);
        studentRepository.save(student);
    }
}
