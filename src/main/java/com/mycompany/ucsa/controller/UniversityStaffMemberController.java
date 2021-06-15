package com.mycompany.ucsa.controller;

import org.slf4j.LoggerFactory;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
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

//import com.mycompany.ucsa.entities.Course;
import com.mycompany.ucsa.entities.UniversityStaffMember;
//import com.mycompany.ucsa.exception.CourseNotFoundException;
import com.mycompany.ucsa.exception.StaffMemberNotFoundException;
import com.mycompany.ucsa.service.IUniversityStaffService;

//import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/universitystaffmember")
public class UniversityStaffMemberController {

	
	Logger logger = LoggerFactory.getLogger(UniversityStaffMemberController.class);
	@Autowired
	private IUniversityStaffService service;

	@GetMapping("/viewAllStaffs")
	public List<UniversityStaffMember> fetchAll() {
		return service.fetchAll();
	}

	@GetMapping("/viewStaffById/{staffId}")
	public UniversityStaffMember fetchById(@PathVariable int staffId) throws StaffMemberNotFoundException {
		logger.info("Inside fetchById ", staffId);
		return service.fetchById(staffId);
	}

	@PostMapping("/addStaff")
	public ResponseEntity<UniversityStaffMember> save(@Valid @RequestBody UniversityStaffMember universitystaffmember) {
		logger.info("Adding Staff member : " + universitystaffmember);
		UniversityStaffMember um = service.addUniversityStaffMember(universitystaffmember);
		return new ResponseEntity<>(um, HttpStatus.CREATED);
	}

	@PutMapping("/updateStaff")
	public void updateStaff(@Valid @RequestBody UniversityStaffMember universitystaffmember) {
		service.updateStaff(universitystaffmember);
	}

	@DeleteMapping("/delete/{staffId}")

	public ResponseEntity<Void> delete(@PathVariable int staffId) throws StaffMemberNotFoundException {
		logger.info("Deleting a Staff Member");
		service.deleteStaffMember(staffId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	

	

}