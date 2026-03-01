package com.portfolio.LearningRestAPIs.admin.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.LearningRestAPIs.common.response.ApiResponse;
import com.portfolio.LearningRestAPIs.hospital.dto.PatientDto;
import com.portfolio.LearningRestAPIs.hospital.service.PatientService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
  private  final PatientService patientService;
  
  @GetMapping("/patients")
  public ResponseEntity<ApiResponse<List<PatientDto>>> getAllPatients() {
    return ResponseEntity.ok(
      new ApiResponse<>(200, patientService.getAllPatients())
    );
  }
}
