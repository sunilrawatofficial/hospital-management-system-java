package com.portfolio.LearningRestAPIs.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.LearningRestAPIs.hospital.entity.Appointment;
public interface  AppointmentRepository extends JpaRepository<Appointment, Long> {
  
}
