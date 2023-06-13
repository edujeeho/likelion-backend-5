package com.example.mybatis.dao;

import com.example.mybatis.mapper.StudentXmlMapper;
import com.example.mybatis.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class StudentXmlDao {
    private final SqlSessionFactory sessionFactory;

    // Lombok 대체
//    public StudentDao(SqlSessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    public boolean createStudent(Student student) {
        try (SqlSession session = sessionFactory.openSession()){
            StudentXmlMapper studentMapper = session.getMapper(StudentXmlMapper.class);
            studentMapper.insertStudent(student);
            log.info(student.toString());
            studentMapper.insertStudentKeys(student);

            return true;
        }
    }

    public List<Student> readStudentsAll() {
        try (SqlSession session = sessionFactory.openSession()){
            StudentXmlMapper studentMapper = session.getMapper(StudentXmlMapper.class);
            return studentMapper.selectStudentAll();
        }
    }

    public Student readStudent(Long id) {
        try (SqlSession session = sessionFactory.openSession()) {
            StudentXmlMapper studentMapper = session.getMapper(StudentXmlMapper.class);
            return studentMapper.selectStudent(id);
        }
    }

    public Student updateStudent(Student student) {
        try (SqlSession session = sessionFactory.openSession()) {
            StudentXmlMapper studentMapper = session.getMapper(StudentXmlMapper.class);
            studentMapper.updateStudent(student);
            return student;
        }
    }

    public void deleteStudent(Long id) {
        try (SqlSession session = sessionFactory.openSession()) {
            StudentXmlMapper studentMapper = session.getMapper(StudentXmlMapper.class);
            studentMapper.deleteStudent(id);
        }
    }

    public Optional<Student> selectStudentOptional(Long id) {
        try (SqlSession session = sessionFactory.openSession()){
            StudentXmlMapper studentXmlMapper = session.getMapper(StudentXmlMapper.class);
            return studentXmlMapper.selectStudentOptional(id);
        }
    }

    public void insertStudentBatch(List<Student> students) {
        try (SqlSession session = sessionFactory.openSession()) {
            StudentXmlMapper studentXmlMapper = session.getMapper(StudentXmlMapper.class);
            studentXmlMapper.insertStudentBatch(students);
        }
    }

    public List<Student> findByFields(Student student) {
        try (SqlSession session = sessionFactory.openSession()) {
            StudentXmlMapper studentXmlMapper = session.getMapper(StudentXmlMapper.class);
            return studentXmlMapper.findByFields(student);
        }
    }


}
