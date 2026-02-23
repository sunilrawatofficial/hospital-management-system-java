package com.portfolio.LearningRestAPIs.hospital.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 100)
  private String name;


  @OneToOne
  private Doctor headDoctor; // Assuming one doctor can head only one department

  @ManyToMany
  @JoinTable(
    name= "my_dpt_doctors",
    joinColumns = @JoinColumn(name = "dpt_id"),
    inverseJoinColumns = @JoinColumn(name = "doctor_i d")
  )
  private Set<Doctor> doctors = new HashSet<>();
}


