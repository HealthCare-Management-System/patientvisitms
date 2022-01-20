package com.model;

public class DiagnosisDto {

	private int id;
	private String diagnosisCode;
	private String diagnosisDescription;
	private Boolean diagnosisIsDepricated;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiagnosisCode() {
		return diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getDiagnosisDescription() {
		return diagnosisDescription;
	}

	public void setDiagnosisDescription(String diagnosisDescription) {
		this.diagnosisDescription = diagnosisDescription;
	}

	public Boolean getDiagnosisIsDepricated() {
		return diagnosisIsDepricated;
	}

	public void setDiagnosisIsDepricated(Boolean diagnosisIsDepricated) {
		this.diagnosisIsDepricated = diagnosisIsDepricated;
	}

	

}
