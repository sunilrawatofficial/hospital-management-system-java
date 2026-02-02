package com.portfolio.LearningRestAPIs.student.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.portfolio.LearningRestAPIs.exception.StudentNotFoundException;
import com.portfolio.LearningRestAPIs.student.dto.StudentDto;
import com.portfolio.LearningRestAPIs.student.entity.Student;
import com.portfolio.LearningRestAPIs.student.repository.StudentRepository;
import com.portfolio.LearningRestAPIs.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = repository.findAll();
        return students
                .stream()
                .map(student -> new StudentDto(student))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student studentObj = repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        return new StudentDto(studentObj);
    }

    @Override
    public StudentDto createStudent(StudentDto dto) {
        Student saved = repository.save(new Student(dto.getName(), dto.getEmail()));
        return new StudentDto(saved);
    }

    @Override
    public void deleteStudentById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        repository.delete(student);
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto dto) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        student.updateFromDto(dto);
        Student updated = repository.save(student);
        return new StudentDto(updated);
    }

    @Override
    public StudentDto updateStudentPartially(Long id, Map<String, Object> updates) {
        Student student = repository.findById(id)
          .orElseThrow(() -> new StudentNotFoundException(id));

        updates.forEach((field, value) -> {

            switch (field) {
                case "name" -> {
                  if(!(value instanceof  String)){
                    throw new IllegalArgumentException("name must be a string");
                  }
                  student.setName((String) value);
                }
                case "email" -> {
                  if(!(value instanceof  String)){
                    throw new IllegalArgumentException("email must be a string");
                  }
                  student.setEmail((String) value);
                  }
                default ->
                  throw new IllegalArgumentException( "Field '" + field + "' is not supported");
            }
        });
        Student updated = repository.save(student);
        return new StudentDto(updated);
    }
}
