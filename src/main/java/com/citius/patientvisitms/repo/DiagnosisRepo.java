package com.citius.patientvisitms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citius.patientvisitms.entities.Diagnosis;

public interface DiagnosisRepo extends JpaRepository<Diagnosis, Integer> {
	@Query(value = "SELECT coalesce(max(id), 0) FROM Medication")
	int getMaxTransactionId();
}
