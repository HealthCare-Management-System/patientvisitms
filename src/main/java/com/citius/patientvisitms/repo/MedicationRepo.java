package com.citius.patientvisitms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citius.patientvisitms.entities.Medication;

public interface MedicationRepo extends JpaRepository<Medication, Integer> {

}
