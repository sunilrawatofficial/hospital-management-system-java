package com.portfolio.LearningRestAPIs.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.LearningRestAPIs.student.entity.Student;


@Repository
public interface  StudentRepository extends  JpaRepository<Student, Long> {}
