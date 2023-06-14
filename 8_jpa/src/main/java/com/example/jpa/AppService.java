package com.example.jpa;

import com.example.jpa.entities.StudentEntity;
import com.example.jpa.repos.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


// 주된 비즈니스 로직이 구현되는 공간
// Controller -> Service
// Service
// 1. 데이터베이스 조회
// 2. Component 사용
// 3. 모은 데이터를 가지고 응답 (의사결정)
@Service
public class AppService {

    // @Repository Bean 객체
    private final AppRepository repository;
    // JpaRepository
    private final StudentRepository studentRepository;

    public AppService(
            AppRepository repository,
            StudentRepository studentRepository
            ) {
        this.repository = repository;
        this.studentRepository = studentRepository;
    }

    // CREATE
    public void createStudent(
        String name,
        Integer age,
        String phone,
        String email
    ) {
        // 새로운(new) Student(Entity)를 만들고 싶다
        StudentEntity newEntity = new StudentEntity();
        newEntity.setName(name);
        newEntity.setAge(age);
        newEntity.setPhone(phone);
        newEntity.setEmail(email);
        // repository.save()
        this.studentRepository.save(newEntity);
    }

    // READ
    public void readStudent(Long id) {
        Optional<StudentEntity> optionalStudentEntity
                = this.studentRepository.findById(id);
        // 1. 실제 데이터가 있을 때만
        if (optionalStudentEntity.isPresent()) {
            // 출력한다.
            System.out.println(optionalStudentEntity.get());
        }
        // 2. 결과가 null 이 되었을 경우
        else {
            System.out.println("no result");
        }
    }

    // READ ALL
    public void readStudentAll() {
        System.out.println(
                this.studentRepository.findAll());
    }

    // UPDATE
    public void updateStudent(
            // 어떤 대상을 수정할지 지정해줘야 해요
            Long id,
            // 수정할 데이터
            String name
    ) {
        // 수정할 Entity를 회수
        Optional<StudentEntity> optionalEntity =
                this.studentRepository.findById(id);
        // 수정할 Entity를 찾은 경우
        if (optionalEntity.isPresent()) {
            // 실제 객체 회수
            StudentEntity target = optionalEntity.get();
            // 수정할 데이터 적용
            target.setName(name);
            // save
            this.studentRepository.save(target);
        } else {
            // 없으면 없다고 알려줌
            System.out.println("could not find");
        }
    }

    // DELETE
    public void deleteStudent(Long id) {
        Optional<StudentEntity> optionalEntity =
                this.studentRepository.findById(id);
        // 삭제할 엔티티를 찾은 경우
        if (optionalEntity.isPresent()) {
            StudentEntity studentEntity =
                    optionalEntity.get();
            // 삭제
            this.studentRepository.delete(studentEntity);
        } else {
            System.out.println("could not find");
        }
    }

    // findAllBy
    public void findAllByTest() {
        System.out.println("findAllByOrderByName");
        List<StudentEntity> studentEntities =
                this.studentRepository.findAllByOrderByName();
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("...");

        System.out.println("findAllByOrderByAgeDesc");
        studentEntities =
                this.studentRepository.findAllByOrderByAgeDesc();
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("...");

        System.out.println("findAllByAgeLessThan");
        studentEntities =
                this.studentRepository.findAllByAgeLessThan(21);
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("...");

        System.out.println("findAllByPhoneStartingWith");
        studentEntities =
                this.studentRepository.findAllByPhoneStartingWith("010-");
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("...");
    }
}
