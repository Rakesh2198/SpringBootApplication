package com.mycompany.ucsa.controller;
import java.util.List;

import javax.validation.Valid;

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
import com.mycompany.ucsa.entities.Exam;
import com.mycompany.ucsa.exception.MarksNotFoundException;
import com.mycompany.ucsa.service.IExamService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Exam Details")
public class ExamController {
	Logger logger = LoggerFactory.getLogger(ExamController.class);
	@Autowired
	private IExamService service;
	@GetMapping("/{name}")
	@ApiOperation("Greetings API")
	public String greetings(@PathVariable String name) {
		logger.info("Inside greetings!!");
		return "<h1>Welcome to Spring Boot " + name + "</h1>";
	}
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all exam details")
	public List<Exam> fetch() {
		logger.info("Fetching all Exam records!!");
		return service.fetchAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Exam> save(@RequestBody @Valid Exam exam) {
		logger.info("Adding marks");
		Exam exam1 = service.addMarks(exam);
		return new ResponseEntity<>(exam1, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	@ApiOperation("Update an Exam Record")
	public void update(@RequestBody @Valid Exam exam) {
		logger.info("Updating marks");
		service.updateMarks(exam);
	}
	
	
	@DeleteMapping("/delete/{ExamId}")
	@ApiOperation("Delete an Existing marks of an applicant")
	public ResponseEntity<Void> delete(@PathVariable int ExamId) throws MarksNotFoundException{
		logger.info("Deleting marks");
		service.delMarks(ExamId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/getById/{ExamId}")
	@ApiOperation("Get marks By ID")
	public Exam fetchById(@PathVariable int ExamId) throws MarksNotFoundException{
		logger.info("Inside fetchById %s", ExamId);
		return service.fetchById(ExamId);
	}
}