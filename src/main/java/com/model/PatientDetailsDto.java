package com.model;

import java.util.List;

public class PatientDetailsDto {

	private int id;
	
	private UserDto user;
	private DemographicDto demographic;
	private List<AllergyDto> allergies;

    
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public DemographicDto getDemographic() {
		return demographic;
	}
	public void setDemographic(DemographicDto demographic) {
		this.demographic = demographic;
	}
	public List<AllergyDto> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<AllergyDto> allergies) {
		this.allergies = allergies;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allergies == null) ? 0 : allergies.hashCode());
		result = prime * result + ((demographic == null) ? 0 : demographic.hashCode());
		result = prime * result + id;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientDetailsDto other = (PatientDetailsDto) obj;
		if (allergies == null) {
			if (other.allergies != null)
				return false;
		} else if (!allergies.equals(other.allergies))
			return false;
		if (demographic == null) {
			if (other.demographic != null)
				return false;
		} else if (!demographic.equals(other.demographic))
			return false;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
}
