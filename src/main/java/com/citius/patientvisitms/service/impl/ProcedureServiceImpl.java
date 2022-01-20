package com.citius.patientvisitms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citius.patientvisitms.entities.Procedure;
import com.citius.patientvisitms.repo.ProcedureRepo;
import com.citius.patientvisitms.service.ProcedureService;
import com.model.ProcedureDto;


@Service
public class ProcedureServiceImpl implements ProcedureService{
	
	@Autowired
    private ProcedureRepo repo;
     
	@Override
    public List<ProcedureDto> listAll() {
		List<Procedure> diagnosislist=repo.findAll();
        List<ProcedureDto> dtolist=new ArrayList<>();
        
        for (Procedure entity:diagnosislist) {
        	dtolist.add(convertEntityToDto(entity));
        }
		return dtolist;
    }
     
	@Override
    public ProcedureDto save(ProcedureDto procedure) {
		return  convertEntityToDto(repo.save(convertDtoToEntity(procedure)));
    }
     
	@Override
    public ProcedureDto get(Integer id) {
		return convertEntityToDto(repo.findById(id).get());
    }
     
	@Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

	@Override
	public ProcedureDto convertEntityToDto(Procedure procedure) {

		ProcedureDto dto= new ProcedureDto();
		dto.setId(procedure.getId());
		dto.setProcedureCode(procedure.getProcedureCode());
		dto.setProcedureDescription(procedure.getProcedureDescription());
		dto.setProcedureDepricated(procedure.getProcedureDepricated());
		
		return null;
	}

	@Override
	public Procedure convertDtoToEntity(ProcedureDto dto) {
		Procedure procedure = new Procedure();
		procedure.setId(dto.getId());
		procedure.setProcedureCode(dto.getProcedureCode());
		procedure.setProcedureDescription(dto.getProcedureDescription());
		procedure.setProcedureDepricated(dto.getProcedureDepricated());
		return procedure;
	}

}
