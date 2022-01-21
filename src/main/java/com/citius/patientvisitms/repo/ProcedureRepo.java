package com.citius.patientvisitms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citius.patientvisitms.entities.Procedure;



public interface ProcedureRepo extends JpaRepository<Procedure, Integer>{
	@Query(value = "SELECT coalesce(max(id), 0) FROM Medication")
	int getMaxTransactionId();
}
