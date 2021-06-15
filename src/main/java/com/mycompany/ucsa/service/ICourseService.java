package com.mycompany.ucsa.service;

import java.util.List;


import org.springframework.stereotype.Service;

import  com.mycompany.ucsa.dto.OrderResponse;
//import com.cg.cms.dto.OrderResponse;
import com.mycompany.ucsa.entities.Course;
import com.mycompany.ucsa.exception.CourseNotFoundException;

@Service
public interface ICourseService {
	Course addCourse(Course course);

	List<Course> fetchAll();

	void delCourse(int id) throws CourseNotFoundException;

	void updateCourse(Course course);

	Course fetchById(int id) throws CourseNotFoundException;
	
	public List<OrderResponse> viewFacultyByCourse(int it);

	

}
