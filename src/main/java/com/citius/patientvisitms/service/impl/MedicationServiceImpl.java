package com.citius.patientvisitms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citius.patientvisitms.entities.Medication;
import com.citius.patientvisitms.repo.MedicationRepo;
import com.citius.patientvisitms.service.MedicationService;
import com.model.MedicationDto;

@Service
public class MedicationServiceImpl implements MedicationService {

	@Autowired
	private MedicationRepo repo;

	@Override
	public List<MedicationDto> listAll() {
		List<Medication> diagnosislist = repo.findAll();
		List<MedicationDto> dtolist = new ArrayList<>();

		for (Medication entity : diagnosislist) {
			dtolist.add(convertEntityToDto(entity));
		}
		return dtolist;
	}

	@Override
	public MedicationDto save(MedicationDto medication) {

		int id = repo.getMaxTransactionId();

		Medication medi = convertDtoToEntity(medication);
		System.out.println("print id of medication " + id);
		medi.setId(id + 1);
		return convertEntityToDto(repo.save(medi));

	}

	@Override
	public MedicationDto get(Integer id) {
		return convertEntityToDto(repo.findById(id).get());
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public MedicationDto convertEntityToDto(Medication medication) {
		MedicationDto dto = new MedicationDto();

		dto.setId(medication.getId());
		dto.setDrugBrandName(medication.getDrugBrandName());
		dto.setDrugForm(medication.getDrugForm());
		dto.setDrugGenericName(medication.getDrugGenericName());
		dto.setDrugName(medication.getDrugName());
		dto.setDrugStrength(medication.getDrugStrength());

		return dto;
	}

	@Override
	public Medication convertDtoToEntity(MedicationDto dto) {
		Medication medication = new Medication();
		medication.setId(dto.getId());
		medication.setDrugBrandName(dto.getDrugBrandName());
		medication.setDrugForm(dto.getDrugForm());
		medication.setDrugGenericName(dto.getDrugGenericName());
		medication.setDrugName(dto.getDrugName());
		medication.setDrugStrength(dto.getDrugStrength());

		return medication;
	}

}
