package com.citius.patientvisitms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citius.patientvisitms.entities.Diagnosis;
import com.citius.patientvisitms.entities.Medication;
import com.citius.patientvisitms.repo.DiagnosisRepo;
import com.citius.patientvisitms.service.DiagnosisService;
import com.model.DiagnosisDto;


@Service
public class DiagnosisServiceImpl implements DiagnosisService{

	@Autowired
    private DiagnosisRepo repo;
     
	@Override
    public List<DiagnosisDto> listAll() {
        List<Diagnosis> diagnosislist=repo.findAll();
        List<DiagnosisDto> dtolist=new ArrayList<>();
		
        for (Diagnosis entity:diagnosislist) {
        	dtolist.add(convertEntityToDto(entity));
        }
		return dtolist;
    }
     
	@Override
    public DiagnosisDto save(DiagnosisDto diagnosis) {
		System.out.println("inside diadnosis save method");
		int id = repo.getMaxTransactionId();

		Diagnosis dia = convertDtoToEntity(diagnosis);
		System.out.println("print id of medication " + id);
		dia.setId(id + 1);
		return convertEntityToDto(repo.save(dia));
	
     
    }
     
	@Override
    public DiagnosisDto get(Integer id) {
        return convertEntityToDto(repo.findById(id).get());
    }
     
	@Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

	@Override
	public DiagnosisDto convertEntityToDto(Diagnosis diagnosis) {
		
		DiagnosisDto dto =new DiagnosisDto();
		
		dto.setId(diagnosis.getId());
		dto.setDiagnosisCode(diagnosis.getDiagnosisCode());
		dto.setDiagnosisDescription(diagnosis.getDiagnosisDescription());
		dto.setDiagnosisIsDepricated(diagnosis.getDiagnosisIsDepricated());
		
		return dto;
	}

	@Override
	public Diagnosis convertDtoToEntity(DiagnosisDto dto) {
		Diagnosis diagnosis = new Diagnosis();
		diagnosis.setId(dto.getId());
		diagnosis.setDiagnosisCode(dto.getDiagnosisCode());
		diagnosis.setDiagnosisDescription(dto.getDiagnosisDescription());
		diagnosis.setDiagnosisIsDepricated(dto.getDiagnosisIsDepricated());
		return diagnosis;
	}
}
