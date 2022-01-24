package com.model;

public class VitalSignsDto {

	private int id;
	private String height;
	private String weight;
	private String bloodPressure;
	private String bodyTemperature;
	private String respirationRate;
	private String dateTime;
	private PatientDetailsDto patientInfoId;
	private UserDto employeeId;
	private String meetingid;

	
	
	
	public String getMeetingid() {
		return meetingid;
	}

	public void setMeetingid(String meetingid) {
		this.meetingid = meetingid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(String bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	public String getRespirationRate() {
		return respirationRate;
	}

	public void setRespirationRate(String respirationRate) {
		this.respirationRate = respirationRate;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}



	public PatientDetailsDto getPatientInfoId() {
		return patientInfoId;
	}

	public void setPatientInfoId(PatientDetailsDto patientInfoId) {
		this.patientInfoId = patientInfoId;
	}

	public UserDto getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(UserDto employeeId) {
		this.employeeId = employeeId;
	}

	

}
