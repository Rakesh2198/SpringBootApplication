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

import com.mycompany.ucsa.dto.OrderResponse;
import com.mycompany.ucsa.entities.Course;
import com.mycompany.ucsa.exception.CourseNotFoundException;
import com.mycompany.ucsa.service.ICourseService;

import io.swagger.annotations.ApiOperation;

	@RestController
	@RequestMapping("/courses")
	public class CourseController {

		Logger logger = LoggerFactory.getLogger(CourseController.class);

		@Autowired
		private ICourseService service;

		

		@GetMapping("/getById/{id}")
		@ApiOperation("Get Course By ID")
		public Course fetchById(@PathVariable int id) throws NumberFormatException, CourseNotFoundException {
			logger.info("Inside fetchById %s",id);
			return service.fetchById(id);
		}

		@GetMapping("/getAll")
		@ApiOperation("Fetch all Course Details")
		public List<Course> fetch() {
			logger.info("Fetching all course records!!");
			return service.fetchAll();
		}

		@PostMapping("/save")
		@ApiOperation("Add a Course Record")
		public ResponseEntity<Course> save(@Valid @RequestBody Course course) {
			logger.info("Adding a course: " + course);
			Course course1 = service.addCourse(course);
			return new ResponseEntity<>(course1, HttpStatus.CREATED);
		}

		@PutMapping("/update")
		@ApiOperation("Update an Existing Course Record")
		public void update(@Valid @RequestBody Course course) {
			logger.info("Updating a course!!");
			service.updateCourse(course);
		}

		@DeleteMapping("/delete/{id}")
		@ApiOperation("Delete an Existing course Record")
		public ResponseEntity<Void> delete(@PathVariable int id) throws CourseNotFoundException {
			logger.info("Deleting a course!!");
			service.delCourse(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		@GetMapping("/getFacultyByCourse/{id}")
		@ApiOperation("Get Course By ID")
		public List<OrderResponse> fetchFacultyByCourse(@PathVariable int id) {
			logger.info("Inside fetchById %s",id);
			return service.viewFacultyByCourse(id);
		}

}
