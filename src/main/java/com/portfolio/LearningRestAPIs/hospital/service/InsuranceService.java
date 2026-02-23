package com.portfolio.LearningRestAPIs.hospital.service;

import org.springframework.stereotype.Service;

import com.portfolio.LearningRestAPIs.hospital.entity.Insurance;
import com.portfolio.LearningRestAPIs.hospital.entity.Patient;
import com.portfolio.LearningRestAPIs.hospital.repository.InsuranceRepository;
import com.portfolio.LearningRestAPIs.hospital.repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class InsuranceService {
  private final InsuranceRepository insuranceRepository;
  private final PatientRepository patientRepository;

  public InsuranceService(InsuranceRepository insuranceRepository, PatientRepository patientRepository) {
    this.insuranceRepository = insuranceRepository;
    this.patientRepository = patientRepository;
  }

  @Transactional
  public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
    Patient patient = patientRepository.findById(patientId)
        .orElseThrow(() -> new EntityNotFoundException("Patient not found With id: " + patientId));

    patient.setInsurance(insurance);
    // insurance.setPatient(patient); //only for bidirectional consistency
    return patient;
  }
  @Transactional
  public Patient disassociateInsuranceFromPatient(Long patientId) {
    Patient patientFromDB = patientRepository.findById(patientId)
        .orElseThrow(() -> new EntityNotFoundException("Patient not found With id: " + patientId));
    patientFromDB.setInsurance(null);
    return patientFromDB;
  }
}
