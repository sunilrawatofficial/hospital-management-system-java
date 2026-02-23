package com.portfolio.LearningRestAPIs.hospital.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.LearningRestAPIs.hospital.entity.Patient;
import com.portfolio.LearningRestAPIs.hospital.entity.type.BloodGroupType;

public interface  PatientRepository extends JpaRepository<Patient, Long> {
  
  Patient findByName(String name);
  
  List<Patient> findByBirthDate(LocalDate birthDate);

  @Query(value = "SELECT * FROM patient", nativeQuery = true)
  List<Patient> findAllPatients();

  @Query("Select p.bloodGroup, Count(p) From Patient p GROUP BY p.bloodGroup")
  List<Object[]> countEachBloodGroupType(@Param("bloodGroup") BloodGroupType bloodGroupType);


  @Transactional
  @Modifying
  @Query(value = "UPDATE patient SET name = :name WHERE id = :id", nativeQuery = true)
  int updateNameById(@Param("name") String name, @Param("id") Long id);



  @Query(value = "SELECT * FROM patient", nativeQuery = true)
  Page<Patient> findPatientWithPagination(Pageable pageable);


  @Query("SELECT p from Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor")
  List<Patient> findAllPatientWithAppointment();
}
