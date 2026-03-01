package com.portfolio.LearningRestAPIs.hospital.dto;

import com.portfolio.LearningRestAPIs.hospital.entity.Patient;
import com.portfolio.LearningRestAPIs.hospital.entity.type.BloodGroupType;
import com.portfolio.LearningRestAPIs.hospital.entity.type.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
  private Long id;
  private String name;
  private String email;
  private Gender gender;
  private BloodGroupType blood_group;

  public PatientDto(Patient entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.name = entity.getName();
    this.gender = entity.getGender();
    this.blood_group = entity.getBloodGroup();
  }
} 
