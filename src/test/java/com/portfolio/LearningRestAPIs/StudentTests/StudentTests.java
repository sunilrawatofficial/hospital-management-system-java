package com.portfolio.LearningRestAPIs.StudentTests;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.portfolio.LearningRestAPIs.student.entity.Student;
import com.portfolio.LearningRestAPIs.student.repository.StudentRepository;  
 
@SpringBootTest
public class StudentTests {

  @Autowired
  private StudentRepository studentRepository;

  @Test
  public void testStudentRepository() {
    List<Student> students = studentRepository.findAll();
    System.out.println("Number of students: " + students);
  }
  
}
