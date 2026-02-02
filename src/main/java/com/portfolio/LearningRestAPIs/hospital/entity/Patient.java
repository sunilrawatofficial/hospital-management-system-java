package com.portfolio.LearningRestAPIs.hospital.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.portfolio.LearningRestAPIs.hospital.entity.type.BloodGroupType;
import com.portfolio.LearningRestAPIs.hospital.entity.type.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(
  name="patient", // table name in the database
  uniqueConstraints = {// user for multiple columns
    @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name", "birthDate"})
  },
  indexes = {
    @Index(name = "idx_patient_birth_date", columnList = "birthDate")
  }
)
public class Patient { //default without table annotation

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column(nullable=false, length=40)
  private String name;
  
  @ToString.Exclude
  @Column(name = "birth_date", nullable = false)
  private LocalDate birthDate;

  @Column(unique=true, nullable=false)
  private String email;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Enumerated(EnumType.STRING)
  private BloodGroupType bloodGroup;

  @CreationTimestamp
  @Column(updatable=false)
  private LocalDateTime createdAt;
}
