package com.example.mybatis;

import com.example.mybatis.dao.StudentXmlDao;
import com.example.mybatis.jdbc.JdbcDao;
import com.example.mybatis.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class MybatisApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext
				= SpringApplication.run(MybatisApplication.class, args);

//		StudentDaoA dao = applicationContext.getBean(StudentDaoA.class);
		StudentXmlDao dao = applicationContext.getBean(StudentXmlDao.class);
		Student student = new Student();
		student.setName("alex");
		student.setAge(30);
		student.setPhone("010-1234-5678");
		student.setEmail("alex@gmail.com");
		// Create
		dao.createStudent(student);

		// Read
		log.info(dao.readStudent(1L).toString());
		log.info(dao.readStudentsAll().toString());

		// Update
		Student alex = dao.readStudent(1L);
		if (alex != null) {
			alex.setName("alexandar");
			dao.updateStudent(alex);
		}

		// Delete
		dao.deleteStudent(2L);
		dao.deleteStudent(3L);

		// Select with optional
		log.info(dao.selectStudentOptional(9999L).toString());

		// Insert into multi dynamic SQL foreach
		Student ash = new Student();
		ash.setName("ash");
		Student brock = new Student();
		brock.setName("brock");
		Student misty = new Student();
		misty.setName("misty");

		List<Student> batchStudents = new ArrayList<>();
		batchStudents.add(ash);
		batchStudents.add(brock);
		batchStudents.add(misty);
		dao.insertStudentBatch(batchStudents);

		// Select with where dynamic SQL if
		Student target = new Student();
		target.setName("alex");
		target.setAge(31);
		log.info(dao.findByFields(target).toString());
	}

}
