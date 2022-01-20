package com.citius.patientvisitms.service;

import java.util.List;

import com.citius.patientvisitms.entities.PatientVistInfo;
import com.model.PatientVistInfoDto;

public interface PatientVistInfoService {

	public List<PatientVistInfoDto> listAll();

	public PatientVistInfoDto save(PatientVistInfoDto patientvisiteinfo);

	public PatientVistInfoDto get(Integer id);

	public void delete(Integer id);

	public PatientVistInfoDto convertEntityToDto(PatientVistInfo patientvisiteinfo);

	public PatientVistInfo convertDtoToEntity(PatientVistInfoDto dto);
}
