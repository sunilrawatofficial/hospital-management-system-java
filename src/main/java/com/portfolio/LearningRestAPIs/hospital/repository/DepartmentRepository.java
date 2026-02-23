package com.portfolio.LearningRestAPIs.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.LearningRestAPIs.hospital.entity.Department;

public interface DepartmentRepository extends  JpaRepository<Department, Long>{
  
}
