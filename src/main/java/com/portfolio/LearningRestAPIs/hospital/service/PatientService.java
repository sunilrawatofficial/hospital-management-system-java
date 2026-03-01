package com.portfolio.LearningRestAPIs.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.LearningRestAPIs.hospital.entity.Patient;
import com.portfolio.LearningRestAPIs.hospital.dto.PatientDto;

import com.portfolio.LearningRestAPIs.hospital.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
  private final PatientRepository patientRepository;

  @Transactional
  public Patient getPatientById(Long Id) {
    Patient p1 = patientRepository.findById(Id).orElse(null);
    Patient p2 = patientRepository.findById(Id).orElse(null);
    return p1;
  }

   public List<PatientDto> getAllPatients() {
      List<Patient> patientFromDB = patientRepository.findAll();
      return patientFromDB
        .stream()
        .map(patient -> new PatientDto(patient))
        .toList();
  }
}
