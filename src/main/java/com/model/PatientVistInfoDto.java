package com.model;

public class PatientVistInfoDto {

	private int id;
	private VitalSignsDto vitalSignId;
	private UserDto employeeId;
	private DiagnosisDto disgnosis;
	private ProcedureDto procedure;
	private MedicationDto medication;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public VitalSignsDto getVitalSignId() {
		return vitalSignId;
	}

	public void setVitalSignId(VitalSignsDto vitalSignId) {
		this.vitalSignId = vitalSignId;
	}

	public UserDto getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(UserDto employeeId) {
		this.employeeId = employeeId;
	}

	public DiagnosisDto getDisgnosis() {
		return disgnosis;
	}

	public void setDisgnosis(DiagnosisDto disgnosis) {
		this.disgnosis = disgnosis;
	}

	public ProcedureDto getProcedure() {
		return procedure;
	}

	public void setProcedure(ProcedureDto procedure) {
		this.procedure = procedure;
	}

	public MedicationDto getMedication() {
		return medication;
	}

	public void setMedication(MedicationDto medication) {
		this.medication = medication;
	}

	
}
