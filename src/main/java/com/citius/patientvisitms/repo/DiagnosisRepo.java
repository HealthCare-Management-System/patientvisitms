package com.citius.patientvisitms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citius.patientvisitms.entities.Diagnosis;

public interface DiagnosisRepo extends JpaRepository<Diagnosis, Integer> {

}
