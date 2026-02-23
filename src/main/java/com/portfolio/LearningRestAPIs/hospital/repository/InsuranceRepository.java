package com.portfolio.LearningRestAPIs.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.LearningRestAPIs.hospital.entity.Insurance;

public interface  InsuranceRepository extends JpaRepository<Insurance, Long> {
  
}
