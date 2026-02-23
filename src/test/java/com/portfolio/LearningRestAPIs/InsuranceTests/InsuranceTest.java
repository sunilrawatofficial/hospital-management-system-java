package com.portfolio.LearningRestAPIs.InsuranceTests;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.portfolio.LearningRestAPIs.hospital.entity.Insurance;
import com.portfolio.LearningRestAPIs.hospital.entity.Patient;
import com.portfolio.LearningRestAPIs.hospital.service.InsuranceService;


@SpringBootTest
public class InsuranceTest {

  @Autowired
  private InsuranceService insuranceService;

  @Test
  public void testInsurance() {
    Insurance insurance = Insurance.builder()
              .policyNumber("POL-1001")
              .provider("HDFC ERGO")
              .validUntil(LocalDate.of(2030, 12, 12))
              .build();

    Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1l);
    System.out.println("[insuranceService] ===>: " +patient);

    var modifiedPatient =insuranceService.disassociateInsuranceFromPatient(patient.getId());
    System.out.println("[modifiedPatient] ===>: " +modifiedPatient);
  }
  
}
