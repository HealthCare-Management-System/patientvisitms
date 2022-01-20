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

import com.citius.patientvisitms.service.ProcedureService;
import com.model.ProcedureDto;

@RestController
@RequestMapping("/procedure")
public class ProcedureController {

	@Autowired
    private ProcedureService service;
	
	@GetMapping
	public List<ProcedureDto> list() {
	    return service.listAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProcedureDto> get(@PathVariable Integer id) {
	    try {
	    	ProcedureDto procedure = service.get(id);
	        return new ResponseEntity<ProcedureDto>(procedure, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<ProcedureDto>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping
	public ResponseEntity<ProcedureDto> add(@RequestBody ProcedureDto procedure) {
	    return new ResponseEntity<ProcedureDto>(service.save(procedure), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProcedureDto> update(@RequestBody ProcedureDto procedure, @PathVariable Integer id) {
	    try {
	    	ProcedureDto exist = service.get(id);
	    	ProcedureDto check = service.save(procedure);
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
