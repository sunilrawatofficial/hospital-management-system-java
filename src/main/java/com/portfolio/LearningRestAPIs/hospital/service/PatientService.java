package com.portfolio.LearningRestAPIs.hospital.service;

import org.springframework.stereotype.Service;

import com.portfolio.LearningRestAPIs.hospital.entity.Patient;
import com.portfolio.LearningRestAPIs.hospital.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
  private final PatientRepository patientRepository;

  // public PatientService(PatientRepository patientRepository) {
  //   this.patientRepository = patientRepository;
  // }

  @Transactional
  public Patient getPatientById(Long Id) {
    Patient p1 = patientRepository.findById(Id).orElse(null);
    Patient p2 = patientRepository.findById(Id).orElse(null);
    return p1;
  }
}
