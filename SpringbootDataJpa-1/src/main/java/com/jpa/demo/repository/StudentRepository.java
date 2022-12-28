package com.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.demo.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
