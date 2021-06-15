package com.mycompany.ucsa.controller;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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


import com.mycompany.ucsa.dto.OrderResponse1;
import com.mycompany.ucsa.entities.Admission;
import com.mycompany.ucsa.exception.AdmissionNotGrantedException;
import com.mycompany.ucsa.exception.ApplicantNotFoundException;
import com.mycompany.ucsa.service.IAdmissionService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admission")
public class AdmissionController {
	
	Logger logger = LoggerFactory.getLogger(AdmissionController.class);

	@Autowired
	private IAdmissionService service;
	
	@PostMapping("/save")
	@ApiOperation("Add Admission Record")
	public ResponseEntity<Admission> save(@RequestBody Admission admission) {
		logger.info("Adding admission:"+admission);
		Admission adm = service.addAdmission(admission);
		return new ResponseEntity<>(adm, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	@ApiOperation("Update an Existing Admission Record")
	public void update(@RequestBody Admission admission) {
		logger.info("Updating admission:"+admission);
		service.updateAdmission(admission);
	}
	
	@DeleteMapping("/delete/{admissionId}")
	@ApiOperation("Cancel Existing Admission")
	public ResponseEntity<Void> delete(@PathVariable int admissionId) throws AdmissionNotGrantedException {
		logger.info("Deleting an Admission record");
		service.cancelAdmission(admissionId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/getByCourse/{id}")
	@ApiOperation("Get Admission By Course ID")
	public List<OrderResponse1> fetchById(@PathVariable int id) {
		logger.info("Fetching Admission by Course ID:"+id);
		return service.showAllAdmissionsByCourse(id);
	}
	
	@GetMapping("/getByDate/{stringDate}")
	@ApiOperation("Get Admission By Course ID")
	public List<OrderResponse1> fetchByDate(@PathVariable String stringDate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		Date date = formatter.parse(stringDate);
		logger.info("Fetching Admission by date:"+stringDate);
		return service.showAllAdmissionsByDate(date);
	}
	
	@GetMapping("/getByApplicant/{id}")
	@ApiOperation("Get Admission By Applicant ID")
	public List<OrderResponse1> fetchByApplicant(@PathVariable int id) throws ApplicantNotFoundException{
		logger.info("Fetching Admisson by Applicant ID:"+id);
		return service.showAllAdmissionsByApplicant(id);
	}
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all Admission Details")
	public List<Admission> fetch() {
		logger.info("Fetching all customer records!!");
		return service.fetchAll();
	}
	
	
}