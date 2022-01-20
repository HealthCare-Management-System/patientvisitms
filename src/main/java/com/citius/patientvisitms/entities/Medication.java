package com.citius.patientvisitms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="medication")
public class Medication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String drugName;
	private String drugGenericName;
	private String drugBrandName;
	private String drugForm;
	private String drugStrength;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDrugGenericName() {
		return drugGenericName;
	}
	public void setDrugGenericName(String drugGenericName) {
		this.drugGenericName = drugGenericName;
	}
	public String getDrugBrandName() {
		return drugBrandName;
	}
	public void setDrugBrandName(String drugBrandName) {
		this.drugBrandName = drugBrandName;
	}
	public String getDrugForm() {
		return drugForm;
	}
	public void setDrugForm(String drugForm) {
		this.drugForm = drugForm;
	}
	public String getDrugStrength() {
		return drugStrength;
	}
	public void setDrugStrength(String drugStrength) {
		this.drugStrength = drugStrength;
	}
	public Medication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medication(int id, String drugName, String drugGenericName, String drugBrandName, String drugForm,
			String drugStrength) {
		super();
		this.id = id;
		this.drugName = drugName;
		this.drugGenericName = drugGenericName;
		this.drugBrandName = drugBrandName;
		this.drugForm = drugForm;
		this.drugStrength = drugStrength;
	}


    
	

}
