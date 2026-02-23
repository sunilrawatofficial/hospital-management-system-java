package com.portfolio.LearningRestAPIs.PatientTests;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.portfolio.LearningRestAPIs.hospital.entity.Patient;
import com.portfolio.LearningRestAPIs.hospital.entity.type.BloodGroupType;
import com.portfolio.LearningRestAPIs.hospital.repository.PatientRepository;
import com.portfolio.LearningRestAPIs.hospital.service.PatientService;


@SpringBootTest
public class PatientTests {
  @Autowired
  private PatientRepository patientRepository;


  @Autowired
  private PatientService patientService;

  @Test
  public void testFindAllPatients(){
    List <Patient> patientList = patientRepository.findAllPatients(); //n+1 problem
    List<Patient> patientListWithAppointment = patientRepository.findAllPatientWithAppointment(); // solve n+1 problem>

    for(Patient item: patientListWithAppointment) {
      System.out.println("[patientList]: ===> "+item.getName()+", "+item.getEmail()+", Appointments: "+item.getAppointments());
    }
  }

  @Test
  public void testTransactionMethod(){
    Patient patient = patientService.getPatientById(1L);
    System.out.println(patient);
  }

  @Test
  public void testFindByName() {
    Patient patient = patientRepository.findByName("Peter Parker");
    System.out.println("Patient Info: ===> "+patient.getName()+", "+patient.getEmail() +", "+patient.getBirthDate());
  }

  @Test
  public void testFindByBirthDate() {
    List<Patient> patients = patientRepository.findByBirthDate(LocalDate.of(1993, 9, 22));
    System.out.println(patients); 
  }

  @Test
  public void testCountEachBloodGroupType() {
    List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType(BloodGroupType.A_NEGATIVE);

    for(Object[] object: bloodGroupList) {
      System.out.println(object[0]+ " "+object[1]); 
    }
  }

  @Test
  public void testUpdateNameById() {
    int rowAffected = patientRepository.updateNameById("Peter Parker", 1L);
    System.out.println("Rows affected: "+rowAffected);
  }
  @Test
  public void testPaginate() {
    Page<Patient> patientList = patientRepository.findPatientWithPagination(PageRequest.of(0, 5, Sort.by("id").ascending()));
    for (Patient patient : patientList) {
      System.out.println(patient);
    }
  }
}
