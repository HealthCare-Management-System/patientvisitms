package com.citius.patientvisitms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citius.patientvisitms.entities.PatientVistInfo;

public interface PatientVistInfoRepo extends JpaRepository<PatientVistInfo, Integer>{

	
	List<PatientVistInfo> findAllByVitalSignId(int id);
	
}
