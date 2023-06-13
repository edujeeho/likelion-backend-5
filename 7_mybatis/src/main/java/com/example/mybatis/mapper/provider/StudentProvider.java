package com.example.mybatis.mapper.provider;

import com.example.mybatis.model.Student;
import org.apache.ibatis.jdbc.SQL;


public class StudentProvider {
    public String findByFields(final Student student) {
        return new SQL() {{
            SELECT("*");
            FROM("students");
            WHERE("name = #{name}");
            if (student.getAge() != null) {
                WHERE("age = #{age}");
            }
        }}.toString();
    }
}
