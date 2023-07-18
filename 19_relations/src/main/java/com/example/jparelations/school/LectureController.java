package com.example.jparelations.school;


import com.example.jparelations.school.repo.InstructorRepository;
import com.example.jparelations.school.repo.LectureRepository;
import com.example.jparelations.school.dto.InstructorDto;
import com.example.jparelations.school.dto.LectureDto;
import com.example.jparelations.school.entity.Instructor;
import com.example.jparelations.school.entity.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("lectures")
@RequiredArgsConstructor
public class LectureController {
    private final LectureRepository lectureRepository;
    private final InstructorRepository instructorRepository;


    @PostMapping
    public LectureDto createLecture(
            @RequestBody LectureDto lectureDto
    ) {
        return LectureDto.fromEntity(
                lectureRepository.save(lectureDto.newEntity()));
    }

    @GetMapping
    public List<LectureDto> readLectureAll() {
        List<LectureDto> lectureList = new ArrayList<>();
        for (Lecture lecture: lectureRepository.findAll())
            lectureList.add(LectureDto.fromEntity(lecture));
        return lectureList;
    }

    @GetMapping("{id}")
    public LectureDto readLecture(@PathVariable("id") Long id) {
        Optional<Lecture> optionalLecture
                = lectureRepository.findById(id);
        if (optionalLecture.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        return LectureDto.fromEntity(optionalLecture.get());
    }

    @PutMapping("{id}/instructor/{instructorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLectureInstructor(
            @PathVariable("id") Long id,
            @PathVariable("instructorId") Long instructorId
    ) {
        Optional<Lecture> optionalLecture
                = lectureRepository.findById(id);
        if (optionalLecture.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Optional<Instructor> optionalInstructor
                = instructorRepository.findById(instructorId);
        if (optionalInstructor.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Lecture lecture = optionalLecture.get();
        Instructor instructor = optionalInstructor.get();

        lecture.setInstructor(instructor);
        lectureRepository.save(lecture);
    }

    @DeleteMapping("{id}/instructor")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLectureInstructor(
            @PathVariable("id") Long id
    ) {
        Optional<Lecture> optionalLecture
                = lectureRepository.findById(id);
        if (optionalLecture.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Lecture lecture = optionalLecture.get();
        lecture.setInstructor(null);
        lectureRepository.save(lecture);
    }

    @GetMapping("{id}/instructor")
    public InstructorDto readLectureInstructor(
            @PathVariable("id") Long id
    ) {
        Optional<Lecture> optionalLecture
                = lectureRepository.findById(id);
        if (optionalLecture.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Lecture lecture = optionalLecture.get();
        if (lecture.getInstructor() == null)
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        return InstructorDto.fromEntity(
                optionalLecture
                        .get()
                        .getInstructor());
    }

}
