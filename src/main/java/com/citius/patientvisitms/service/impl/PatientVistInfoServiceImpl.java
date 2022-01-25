package com.citius.patientvisitms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citius.patientvisitms.entities.PatientVistInfo;
import com.citius.patientvisitms.repo.PatientVistInfoRepo;
import com.citius.patientvisitms.service.DiagnosisService;
import com.citius.patientvisitms.service.MedicationService;
import com.citius.patientvisitms.service.PatientVistInfoService;
import com.citius.patientvisitms.service.ProcedureService;
import com.model.PatientDetailsDto;
import com.model.PatientVistInfoDto;
import com.model.UserDto;
import com.model.VitalSignsDto;

@Service
public class PatientVistInfoServiceImpl implements PatientVistInfoService {

	@Autowired
	private PatientVistInfoRepo repo;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiagnosisService diagnosisService;

	@Autowired
	private MedicationService medicationService;

	@Autowired
	private ProcedureService procedureService;

	@Override
	public List<PatientVistInfoDto> listAll() {
		List<PatientVistInfo> diagnosislist = repo.findAll();
		List<PatientVistInfoDto> dtolist = new ArrayList<>();

		for (PatientVistInfo entity : diagnosislist) {
			dtolist.add(convertEntityToDto(entity));
		}
		return dtolist;
	}

	@Override
	public List<PatientVistInfoDto> listAllByPatientId(int id) {
		List<PatientVistInfo> diagnosislist = repo.findAll();
		List<PatientVistInfoDto> dtolist = new ArrayList<>();
		PatientDetailsDto patientdto = getPatientInfoDtoFromPatientMs(id);
		for (PatientVistInfo entity : diagnosislist) {

			VitalSignsDto vitaldto = getVitalSignDtoFromVitalSignMs(entity.getVitalSignId());

			if (vitaldto.getPatientInfoId().getUser().getId()==(patientdto.getUser().getId())) {
				dtolist.add(convertEntityToDto(entity));
			}

		}
		return dtolist;
	}

	@Override
	public PatientVistInfoDto save(PatientVistInfoDto patientvisiteinfo) {

		PatientVistInfo entity = repo.save(convertDtoToEntity(patientvisiteinfo));

		if (entity != null) {
			updateAppointmentStatusById(
					Integer.parseInt(getVitalSignDtoFromVitalSignMs(entity.getVitalSignId()).getMeetingid()));
		}

		return convertEntityToDto(entity);
	}

	@Override
	public PatientVistInfoDto get(Integer id) {
		return convertEntityToDto(repo.findById(id).get());
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
	}

	public Boolean updateAppointmentStatusById(int id) {
		ResponseEntity<Boolean> response = restTemplate
				.getForEntity("http://localhost:8085/appointments/meetingdone/" + id, Boolean.class);
		return response.getBody();
	}

	public UserDto getUserDtoFromUserMs(int id) {
		ResponseEntity<UserDto> response = restTemplate.getForEntity("http://localhost:8081/users/users/" + id,
				UserDto.class);
		return response.getBody();
	}

	public VitalSignsDto getVitalSignDtoFromVitalSignMs(int id) {
		ResponseEntity<VitalSignsDto> response = restTemplate.getForEntity("http://localhost:8082/vitalsigns/" + id,
				VitalSignsDto.class);
		return response.getBody();
	}

	public PatientDetailsDto getPatientInfoDtoFromPatientMs(int id) {
		ResponseEntity<PatientDetailsDto> response = restTemplate
				.getForEntity("http://localhost:8084/patientdetails/" + id, PatientDetailsDto.class);
		return response.getBody();
	}

	@Override
	public PatientVistInfoDto convertEntityToDto(PatientVistInfo patientvisiteinfo) {
		PatientVistInfoDto dto = new PatientVistInfoDto();

		dto.setId(patientvisiteinfo.getId());

		dto.setDisgnosis(diagnosisService.convertEntityToDto(patientvisiteinfo.getDisgnosis()));
		dto.setMedication(medicationService.convertEntityToDto(patientvisiteinfo.getMedication()));
		dto.setProcedure(procedureService.convertEntityToDto(patientvisiteinfo.getProcedure()));

		dto.setEmployeeId(getUserDtoFromUserMs(patientvisiteinfo.getEmployeeId()));
		dto.setVitalSignId(getVitalSignDtoFromVitalSignMs(patientvisiteinfo.getVitalSignId()));

		return dto;
	}

	@Override
	public PatientVistInfo convertDtoToEntity(PatientVistInfoDto dto) {
		PatientVistInfo visistinfo = new PatientVistInfo();

		visistinfo.setId(dto.getId());

		visistinfo.setDisgnosis(diagnosisService.convertDtoToEntity(dto.getDisgnosis()));
		visistinfo.setMedication(medicationService.convertDtoToEntity(dto.getMedication()));
		visistinfo.setProcedure(procedureService.convertDtoToEntity(dto.getProcedure()));

		visistinfo.setEmployeeId(dto.getEmployeeId().getId());
		visistinfo.setVitalSignId(dto.getVitalSignId().getId());

		return visistinfo;
	}

}
