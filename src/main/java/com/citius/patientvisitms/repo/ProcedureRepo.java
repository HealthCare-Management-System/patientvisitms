package com.citius.patientvisitms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citius.patientvisitms.entities.Procedure;



public interface ProcedureRepo extends JpaRepository<Procedure, Integer>{

}
