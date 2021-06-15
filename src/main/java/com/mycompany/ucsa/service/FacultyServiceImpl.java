package com.mycompany.ucsa.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.ucsa.dto.FacultyOrderResponse;
import com.mycompany.ucsa.entities.Faculty;
import com.mycompany.ucsa.exception.FacultyNotFoundException;
import com.mycompany.ucsa.repository.IFacultyRepository;

@Service
public class FacultyServiceImpl implements IFacultyService {

	
	Logger logger = LoggerFactory.getLogger(FacultyServiceImpl.class);
	@Autowired
	private IFacultyRepository repository;

	@Override
	public List<Faculty> fetchAll() {
		return repository.findAll();
	}

	@Override
	public Faculty fetchById(int facultyId) throws FacultyNotFoundException {
		Optional<Faculty> usm = repository.findById(facultyId);
		if (!usm.isPresent())
			throw new FacultyNotFoundException();
		return usm.get();
	}

	
	
	@Override
	public Faculty addFaculty(Faculty usm) {
		logger.info("addFaculty method of FacultyServiceImpl");
		return repository.save(usm);
	}

//	@Override
//	public List<FacultyOrderResponse> viewCourseByFaculty(int FacultyId) {
//		return repository.getCourseByFaculty(FacultyId);
//	}

	

	
	
	

	
	}