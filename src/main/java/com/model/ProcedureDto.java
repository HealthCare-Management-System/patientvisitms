package com.model;

public class ProcedureDto {

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

}
