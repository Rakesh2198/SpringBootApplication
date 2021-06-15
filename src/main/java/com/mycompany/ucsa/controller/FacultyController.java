package com.mycompany.ucsa.controller;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.mycompany.ucsa.dto.FacultyOrderResponse;
import com.mycompany.ucsa.entities.Faculty;
import com.mycompany.ucsa.exception.FacultyNotFoundException;
import com.mycompany.ucsa.service.IFacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

	
	Logger logger = LoggerFactory.getLogger(FacultyController.class);
	@Autowired
	private IFacultyService service;
	
	@PostMapping("/addFaculty")
	public ResponseEntity<Faculty> save(@Valid @RequestBody Faculty faculty) {
		logger.info("Adding Faculty: " + faculty);
		
		Faculty um = service.addFaculty(faculty);
		return new ResponseEntity<>(um, HttpStatus.CREATED);
	}

	@GetMapping("/viewAllFaculty")
	public List<Faculty> fetchAll() {
		return service.fetchAll();
	}

	@GetMapping("/viewFacultyById/{facultyId}")
	public Faculty fetchById(@PathVariable int facultyId) throws NumberFormatException, FacultyNotFoundException {
		logger.info("Inside fetchById ", facultyId);
		return service.fetchById(facultyId);
	}

//	@GetMapping("/viewCourseByFacultyId/{facultyId}")
//	public List<FacultyOrderResponse> fetchCourseByFacultyId(@PathVariable int facultyId) throws NumberFormatException, FacultyNotFoundException {
//		logger.info("fetchCourseByFacultyId", facultyId);
//		return service.viewCourseByFaculty(facultyId);
//	}

	

}