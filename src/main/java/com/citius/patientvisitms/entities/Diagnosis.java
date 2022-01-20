package com.citius.patientvisitms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="diagnosis")
public class Diagnosis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	public Diagnosis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Diagnosis(int id, String diagnosisCode, String diagnosisDescription, Boolean diagnosisIsDepricated) {
		super();
		this.id = id;
		this.diagnosisCode = diagnosisCode;
		this.diagnosisDescription = diagnosisDescription;
		this.diagnosisIsDepricated = diagnosisIsDepricated;
	}
	@Override
	public String toString() {
		return "Diagnosis [id=" + id + ", diagnosisCode=" + diagnosisCode + ", diagnosisDescription="
				+ diagnosisDescription + ", diagnosisIsDepricated=" + diagnosisIsDepricated + "]";
	}
	
	
	
	
    
	

}
