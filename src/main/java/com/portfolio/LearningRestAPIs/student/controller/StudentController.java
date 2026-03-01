package com.portfolio.LearningRestAPIs.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.LearningRestAPIs.common.response.ApiResponse;
import com.portfolio.LearningRestAPIs.student.dto.StudentDto;
import com.portfolio.LearningRestAPIs.student.service.StudentService;

import jakarta.validation.Valid;






@RestController
@RequestMapping("/public")
public class StudentController {

  private final StudentService studentsService;

  @GetMapping("/ping")
  public String ping() {
    return "Welcome to Spring boot";
  }
  public StudentController (StudentService studentsService) {
    this.studentsService = studentsService;
  }

  @GetMapping("")
  public ResponseEntity<ApiResponse<List<StudentDto>>> getStudents() {
    return ResponseEntity.ok(
      new ApiResponse<>(200, studentsService.getAllStudents())
    );
  }

 
  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<StudentDto>> getStudentById(@PathVariable Long  id) {
    return ResponseEntity.ok(new ApiResponse<>(200, studentsService.getStudentById(id)));
  }
  
  @PostMapping("")
  public ResponseEntity<StudentDto> create(@RequestBody @Valid StudentDto dto) {
    return  ResponseEntity.ok(studentsService.createStudent(dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    studentsService.deleteStudentById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody @Valid StudentDto dto) {
    return  ResponseEntity.ok(studentsService.updateStudent(id, dto));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<StudentDto> updateStudentPartially(@PathVariable Long id, @RequestBody @Valid Map<String, Object> updates) {
    return  ResponseEntity.ok(studentsService.updateStudentPartially(id, updates));
  }

}
