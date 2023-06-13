package com.example.mybatis.jdbc;

import com.example.mybatis.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JdbcDao {
    private final DataSource dataSource;

    public void executeInsert(Student student) {
        String sql = "INSERT INTO students (name, age, phone, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getPhone());
            statement.setString(4, student.getEmail());

            statement.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }
}
