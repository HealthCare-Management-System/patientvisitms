package com.citius.patientvisitms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="procedure")
public class Procedure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String procedureCode;
	private String procedureDescription;
	private Boolean procedureDepricated;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProcedureCode() {
		return procedureCode;
	}
	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}
	public String getProcedureDescription() {
		return procedureDescription;
	}
	public void setProcedureDescription(String procedureDescription) {
		this.procedureDescription = procedureDescription;
	}
	public Boolean getProcedureDepricated() {
		return procedureDepricated;
	}
	public void setProcedureDepricated(Boolean procedureDepricated) {
		this.procedureDepricated = procedureDepricated;
	}
	public Procedure() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Procedure(int id, String procedureCode, String procedureDescription, Boolean procedureDepricated) {
		super();
		this.id = id;
		this.procedureCode = procedureCode;
		this.procedureDescription = procedureDescription;
		this.procedureDepricated = procedureDepricated;
	}
	@Override
	public String toString() {
		return "Procedure [id=" + id + ", procedureCode=" + procedureCode + ", procedureDescription="
				+ procedureDescription + ", procedureDepricated=" + procedureDepricated + "]";
	}
	
	
	
	
	
}
