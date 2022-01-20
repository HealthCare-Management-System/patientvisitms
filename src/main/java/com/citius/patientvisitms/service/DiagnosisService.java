package com.citius.patientvisitms.service;

import java.util.List;

import com.citius.patientvisitms.entities.Diagnosis;
import com.model.DiagnosisDto;

public interface DiagnosisService {

	public List<DiagnosisDto> listAll();

	public DiagnosisDto save(DiagnosisDto diagnosis);

	public DiagnosisDto get(Integer id);

	public void delete(Integer id);

	public DiagnosisDto convertEntityToDto(Diagnosis diagnosis);

	public Diagnosis convertDtoToEntity(DiagnosisDto dto);

}
