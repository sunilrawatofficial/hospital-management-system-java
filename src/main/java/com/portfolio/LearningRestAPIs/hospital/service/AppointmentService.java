package com.portfolio.LearningRestAPIs.hospital.service;

import org.springframework.stereotype.Service;

import com.portfolio.LearningRestAPIs.hospital.entity.Appointment;
import com.portfolio.LearningRestAPIs.hospital.entity.Doctor;
import com.portfolio.LearningRestAPIs.hospital.entity.Patient;
import com.portfolio.LearningRestAPIs.hospital.repository.AppointmentRepository;
import com.portfolio.LearningRestAPIs.hospital.repository.DoctorRepository;
import com.portfolio.LearningRestAPIs.hospital.repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;
  private final DoctorRepository doctorRepository;
  private final PatientRepository patientRepository; 

  @Transactional
  public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) {

    Doctor doctorFromDB = doctorRepository.findById(doctorId).orElseThrow(()-> new EntityNotFoundException("Doctor not found"));
    Patient patientFromDB = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient not found"));

    if(appointment.getId() != null) throw new IllegalArgumentException("New appointment cannot have an id"); 

    appointment.setPatient(patientFromDB);
    appointment.setDoctor(doctorFromDB);
    patientFromDB.getAppointments().add(appointment); // to maintain the bidirectional relationship
    doctorFromDB.getAppointments().add(appointment); // to maintain the bidirectional relationship

    return appointmentRepository.save(appointment);
  }

  @Transactional
  public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long newDoctorId) {
    Appointment appointmentFromDB = appointmentRepository.findById(appointmentId).orElseThrow(() -> new EntityNotFoundException("appointment is not created yet"));
    Doctor otherDoctorFromDB = doctorRepository.findById(newDoctorId).orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
    
    appointmentFromDB.setDoctor(otherDoctorFromDB);
    otherDoctorFromDB.getAppointments().add(appointmentFromDB); // to maintain the bidirectional relationship
    return appointmentFromDB;
  }
}
  
