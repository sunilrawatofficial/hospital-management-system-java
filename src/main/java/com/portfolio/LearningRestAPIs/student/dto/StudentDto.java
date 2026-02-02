package com.portfolio.LearningRestAPIs.student.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.portfolio.LearningRestAPIs.student.entity.Student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "name", "email" })
public class StudentDto {
  private Long id;

  @NotBlank(message="Name is required")
  @Size(min= 3, max= 30, message= "Name should be of length of 3 to 30 character")
  private String name;

  @Email 
  @NotBlank(message = "Email is required")
  private String email;
  
  public StudentDto() {
  }
  
  public StudentDto(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  // Mapping constructor
  public StudentDto(Student entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.email = entity.getEmail();
  }
}
