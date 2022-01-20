package com.citius.patientvisitms.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.citius.patientvisitms.entities.Diagnosis;
import com.citius.patientvisitms.service.DiagnosisService;
import com.model.DiagnosisDto;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {
	private static final Logger LOG = LoggerFactory.getLogger(DiagnosisController.class);
		
	@Autowired
    private DiagnosisService service;
	
	@GetMapping
	public List<DiagnosisDto> list() {
	    return service.listAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DiagnosisDto> get(@PathVariable Integer id) {
	    try {
	    	DiagnosisDto diagnosis = service.get(id);
	        return new ResponseEntity<DiagnosisDto>(diagnosis, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<DiagnosisDto>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping
	public ResponseEntity<DiagnosisDto> add(@RequestBody DiagnosisDto diagnosis) {
	        
	    return new ResponseEntity<DiagnosisDto>(service.save(diagnosis), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DiagnosisDto> update(@RequestBody DiagnosisDto diagnosis, @PathVariable Integer id) {
	    try {
	    	DiagnosisDto exist = service.get(id);
	    	DiagnosisDto check= service.save(diagnosis);
	        return new ResponseEntity<>(check,HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
	    service.delete(id);
	}

}
