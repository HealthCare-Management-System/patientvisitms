package com.citius.patientvisitms.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citius.patientvisitms.service.PatientVistInfoService;
import com.model.PatientVistInfoDto;

@RestController
@RequestMapping("/patientvisitinfo")
public class PatientVistInfoController {
	@Autowired
    private PatientVistInfoService service;
	
	
	@GetMapping("/ping")
	public String greetings() {
		return "Working";
	}
	
	@GetMapping
	public List<PatientVistInfoDto> list() {
	    return service.listAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<PatientVistInfoDto> get(@PathVariable Integer id) {
	    try {
	    	PatientVistInfoDto patientVistInfo = service.get(id);
	        return new ResponseEntity<PatientVistInfoDto>(patientVistInfo, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<PatientVistInfoDto>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping
	public ResponseEntity<PatientVistInfoDto>  add(@RequestBody PatientVistInfoDto patientVistInfo) {

	    return new ResponseEntity<PatientVistInfoDto>(service.save(patientVistInfo), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody PatientVistInfoDto patientVistInfo, @PathVariable Integer id) {
	    try {
	    	PatientVistInfoDto exist = service.get(id);
	        service.save(patientVistInfo);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
	    service.delete(id);
	}

}
