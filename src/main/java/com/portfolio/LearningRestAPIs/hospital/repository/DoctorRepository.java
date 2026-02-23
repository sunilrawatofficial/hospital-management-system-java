package com.portfolio.LearningRestAPIs.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.LearningRestAPIs.hospital.entity.Doctor;

public interface DoctorRepository extends  JpaRepository<Doctor, Long> {
  
}
