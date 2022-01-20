package com.citius.patientvisitms.service;

import java.util.List;

import com.citius.patientvisitms.entities.Procedure;
import com.model.ProcedureDto;

public interface ProcedureService {

	public List<ProcedureDto> listAll();

	public ProcedureDto save(ProcedureDto procedure);

	public ProcedureDto get(Integer id);

	public void delete(Integer id);
	
    public ProcedureDto convertEntityToDto(Procedure procedure);
	
	public Procedure convertDtoToEntity(ProcedureDto dto);
}
