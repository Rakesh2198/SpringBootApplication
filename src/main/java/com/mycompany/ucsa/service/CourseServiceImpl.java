package com.mycompany.ucsa.service;

import java.util.List;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.mycompany.ucsa.dto.OrderResponse;

//import com.cg.cms.entities.Customer;
//import com.cg.cms.exception.CustomerNotFoundException;
//import com.cg.cms.repository.CustomerRepository;


import  com.mycompany.ucsa.entities.Course;
import  com.mycompany.ucsa.exception.CourseNotFoundException;
import  com.mycompany.ucsa.repository.CourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {
	
	Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Autowired
	private CourseRepository repository;

	@Override
	public Course addCourse(Course course) {
		logger.info("inside addCourse method of CourseServiceImpl");
		return repository.save(course);
	}

	@Override
	public List<Course> fetchAll() {
		return repository.findAll();
	}

	@Override
	public void delCourse(int id) throws CourseNotFoundException {
		Optional<Course> course = repository.findById(id);
		if (!course.isPresent())
			throw new CourseNotFoundException();

		repository.deleteById(id);
	}

	@Override
	public void updateCourse(Course course) {
		repository.save(course);
	}

	@Override
	public Course fetchById(int id) throws CourseNotFoundException {
		Optional<Course> course = repository.findById(id);
		if (!course.isPresent())
			throw new CourseNotFoundException();

		return course.get();
	}
	

	@Override
	public List<OrderResponse> viewFacultyByCourse(int id) {
	
		return repository.getFacultyNameByCourse(id);
	}

	
}

