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

import com.citius.patientvisitms.service.MedicationService;
import com.model.MedicationDto;

@RestController
@RequestMapping("/medication")
public class MedicationController {

	@Autowired
    private MedicationService service;
	
	@GetMapping
	public List<MedicationDto> list() {
	    return service.listAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<MedicationDto> get(@PathVariable Integer id) {
	    try {
	    	MedicationDto medication = service.get(id);
	        return new ResponseEntity<MedicationDto>(medication, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<MedicationDto>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping
	public ResponseEntity<MedicationDto> add(@RequestBody MedicationDto medication) {
	    return new ResponseEntity<MedicationDto>(service.save(medication), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody MedicationDto medication, @PathVariable Integer id) {
	    try {
	    	MedicationDto exist = service.get(id);
	        service.save(medication);
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
