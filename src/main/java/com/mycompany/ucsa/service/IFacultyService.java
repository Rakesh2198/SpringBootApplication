package com.mycompany.ucsa.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.mycompany.ucsa.dto.FacultyOrderResponse;
import com.mycompany.ucsa.entities.Faculty;
import com.mycompany.ucsa.exception.FacultyNotFoundException;

@Service
public interface IFacultyService {

	List<Faculty> fetchAll();
	
	Faculty fetchById(int facultyId) throws FacultyNotFoundException;

	Faculty addFaculty(@Valid Faculty faculty);
	
	//public List <FacultyOrderResponse> viewCourseByFaculty(int FacultyId);

	
}