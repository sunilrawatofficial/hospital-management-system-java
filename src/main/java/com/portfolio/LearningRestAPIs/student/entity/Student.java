package com.portfolio.LearningRestAPIs.student.entity;

import com.portfolio.LearningRestAPIs.student.dto.StudentDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
// @Table(name = "student")
@Getter
@Setter
@ToString
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;


  // JPA needs no-args constructor
  public  Student() {}

  // For creating entity from DTO
  public Student(String name, String email) {
    this.name = name;
    this.email = email;
  }

  // ✅ UPDATE logic lives here
  public void updateFromDto(StudentDto dto) {
    this.name = dto.getName();
    this.email = dto.getEmail();
  }
}
