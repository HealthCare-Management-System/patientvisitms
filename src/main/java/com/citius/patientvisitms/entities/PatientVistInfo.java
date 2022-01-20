package com.citius.patientvisitms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="patient_visit_info")
public class PatientVistInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int vitalSignId;

	private int employeeId;
	@ManyToOne
	@JoinColumn(name="diagnosis")
	private Diagnosis disgnosis;
	@ManyToOne
	@JoinColumn(name="procedure")
	private Procedure procedure;
	@ManyToOne
	@JoinColumn(name="medication")
	private Medication medication;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getVitalSignId() {
		return vitalSignId;
	}
	public void setVitalSignId(int vitalSignId) {
		this.vitalSignId = vitalSignId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Diagnosis getDisgnosis() {
		return disgnosis;
	}
	public void setDisgnosis(Diagnosis disgnosis) {
		this.disgnosis = disgnosis;
	}
	public Procedure getProcedure() {
		return procedure;
	}
	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}
	public Medication getMedication() {
		return medication;
	}
	public void setMedication(Medication medication) {
		this.medication = medication;
	}
	
	

	
}
