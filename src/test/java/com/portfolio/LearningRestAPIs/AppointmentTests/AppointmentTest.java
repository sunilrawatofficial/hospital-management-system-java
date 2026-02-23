package com.portfolio.LearningRestAPIs.AppointmentTests;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.portfolio.LearningRestAPIs.hospital.entity.Appointment;
import com.portfolio.LearningRestAPIs.hospital.repository.AppointmentRepository;
import com.portfolio.LearningRestAPIs.hospital.service.AppointmentService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class AppointmentTest {

  @Autowired
  private AppointmentService appointmentService;
  @Autowired
  private AppointmentRepository appointmentRepository;


  @Test
  public void testCreateAppointment() {
    Appointment appointment = Appointment.builder()
        .appointmentTime(LocalDateTime.of(2026, 3, 1, 12, 30, 0))
        .reason("Cancer")
        .build();

    var newAppointment = appointmentService.createNewAppointment(appointment, 1L, 1L);
    System.out.println("[newAppointment] ===>" + newAppointment);

    var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 2L);

    System.out.println("[updatedAppointment] ===>" + updatedAppointment);

  }

  @Test
  @Transactional
  public void testFetchAllAppointments() {
    List<Appointment> appointmentList = appointmentRepository.findAll();

    for(Appointment item: appointmentList) {
      System.out.println("[testFetchAllAppointments]: ===> " + item.getDoctor().getName() + " has appointment with " + item.getPatient().getName() + "for the reason of " + item.getReason());
    }
  }
}
