package com.portfolio.LearningRestAPIs.student.service;

import java.util.List;
import java.util.Map;

import com.portfolio.LearningRestAPIs.student.dto.StudentDto;

public interface  StudentService {
  List<StudentDto> getAllStudents();

  StudentDto getStudentById(Long id);

  StudentDto createStudent(StudentDto dto);

  void deleteStudentById(Long id);

  StudentDto updateStudent(Long id, StudentDto dto);

  StudentDto updateStudentPartially(Long id, Map<String, Object> updates);
}

