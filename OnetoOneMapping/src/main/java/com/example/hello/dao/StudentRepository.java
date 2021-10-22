package com.example.hello.dao;

import com.example.hello.entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentDetails,Long> {
    List<StudentDetails> findByName(String name);
}
