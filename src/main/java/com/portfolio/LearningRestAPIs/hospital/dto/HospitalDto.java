package com.portfolio.LearningRestAPIs.hospital.dto;

import com.portfolio.LearningRestAPIs.hospital.entity.type.BloodGroupType;
import com.portfolio.LearningRestAPIs.hospital.entity.type.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDto {
  private Long id;
  private String name;
  private String email;
  private Gender gender;
  private BloodGroupType blood_group;
}
