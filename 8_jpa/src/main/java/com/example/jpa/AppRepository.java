package com.example.jpa;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


// 데이터베이스와의 소통을 담당
@Repository
public class AppRepository {

    public List<Object> selectStudentAll() {
        return new ArrayList<>();
    }
}
