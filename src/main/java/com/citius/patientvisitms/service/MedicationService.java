package com.citius.patientvisitms.service;

import java.util.List;

import com.citius.patientvisitms.entities.Medication;
import com.model.MedicationDto;

public interface MedicationService {

	public List<MedicationDto> listAll();

	public MedicationDto save(MedicationDto medication);

	public MedicationDto get(Integer id);

	public void delete(Integer id);
	
	public MedicationDto convertEntityToDto(Medication medication);
	
	public Medication convertDtoToEntity(MedicationDto dto);
}
