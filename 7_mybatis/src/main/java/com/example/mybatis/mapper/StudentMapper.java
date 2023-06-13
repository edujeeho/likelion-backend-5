package com.example.mybatis.mapper;

import com.example.mybatis.mapper.provider.StudentProvider;
import com.example.mybatis.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StudentMapper {
    // insert
    @Insert("INSERT INTO students(name, age, phone, email)\n" +
            "VALUES(#{name}, #{age}, #{phone}, #{email})")
    void insertStudent(Student student);

    @Insert("INSERT INTO students(name, age, phone, email)\n" +
            "VALUES(#{name}, #{age}, #{phone}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertStudentKeys(Student student);


    // select
    @Select("SELECT * FROM students")
    List<Student> selectStudentAll();

    @Select("SELECT * FROM students WHERE id = #{id}")
    Student selectStudent(Long id);

    // update
    @Update("UPDATE students SET " +
            "name = #{name}," +
            "age = #{age}," +
            "phone = #{phone}," +
            "email = #{email}" +
            "WHERE id = #{id}")
    void updateStudent(Student student);

    // delete
    @Delete("DELETE FROM students " +
            "WHERE id = #{id}")
    void deleteStudent(Long id);

    // select with optional
    @Select("SELECT * FROM students WHERE id = #{id}")
    Optional<Student> selectStudentOptional(Long id);

    // dynamic sql
    @SelectProvider(type = StudentProvider.class, method = "findByFields")
    List<Student> findByFields(Student student);

}
