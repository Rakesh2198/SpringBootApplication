package com.mycompany.ucsa.controller;

import java.util.List;



import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.ucsa.dto.ApplicantOrderResponse;
import com.mycompany.ucsa.entities.Admission;
import com.mycompany.ucsa.entities.AdmissionStatus;
import com.mycompany.ucsa.entities.Applicant;
import com.mycompany.ucsa.exception.AdmissionNotGrantedException;
import com.mycompany.ucsa.exception.ApplicantNotFoundException;
import com.mycompany.ucsa.service.IApplicantService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

	Logger logger = LoggerFactory.getLogger(ApplicantController.class);

	@Autowired
	private IApplicantService service;

	@PostMapping("/save")
	@ApiOperation("Add Applicant Record")
	public ResponseEntity<Applicant> save(@Valid @RequestBody Applicant applicant) {
		logger.info("Adding admission:" + applicant);
		Applicant apn = service.addApplicant(applicant);
		return new ResponseEntity<>(apn, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	@ApiOperation("Update an existing Applicant record")
	public void update(@Valid @RequestBody Applicant applicant) {
		logger.info("Updating admission:" + applicant);
		service.updateApplicant(applicant);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete existing Applicant")
	public ResponseEntity<Void> delete(@PathVariable int id) throws ApplicantNotFoundException {
		logger.info("Deleting an Admission record");
		service.deleteApplicant(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/getAll")
	@ApiOperation("Fetch all Applicant details")
	public List<Applicant> fetch() {
		logger.info("Fetching all applicant records!!");
		return service.fetchAll();
	}

	@GetMapping("/getById/{id}")
	@ApiOperation("Get Applicant By ID")
	public Applicant fetchById(@PathVariable int id) throws ApplicantNotFoundException {
		logger.info("Inside fetchById %s", id);
		return service.viewApplicant(id);
	}
	
	@GetMapping("/getByStatus/{status}")
	@ApiOperation("Get Applicant by admission status")
	public List<ApplicantOrderResponse> fetchByAdmissionStatus(@PathVariable AdmissionStatus status){
		logger.info("Inside fetchById "+status);
		return service.viewAllApplicantsByStatus(status);
	}
}