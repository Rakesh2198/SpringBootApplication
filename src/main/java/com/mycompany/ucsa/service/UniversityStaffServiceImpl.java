package com.mycompany.ucsa.service;

import java.util.List;


import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.mycompany.ucsa.entities.Course;
import com.mycompany.ucsa.entities.UniversityStaffMember;
import com.mycompany.ucsa.exception.StaffMemberNotFoundException;
import com.mycompany.ucsa.repository.IUniversityStaffRepository;

@Service
public class UniversityStaffServiceImpl implements IUniversityStaffService {

	Logger logger = LoggerFactory.getLogger(UniversityStaffServiceImpl.class);
	@Autowired
	private IUniversityStaffRepository repository;

	@Override
	public List<UniversityStaffMember> fetchAll() {
		return repository.findAll();
	}

	@Override
	public UniversityStaffMember fetchById(int staffId) throws StaffMemberNotFoundException {
		Optional<UniversityStaffMember> usm = repository.findById(staffId);
		if (!usm.isPresent())
			throw new StaffMemberNotFoundException();
		return usm.get();
	}

	@Override
	public UniversityStaffMember addUniversityStaffMember(UniversityStaffMember usm) {
		logger.info("addUniversityStaffMember method of UniversityStaffServiceImpl");
		return repository.save(usm);
	}

	@Override
	public void updateStaff(UniversityStaffMember usm) {
		repository.save(usm);
	}

	@Override
	public void deleteStaffMember(int staffId) throws StaffMemberNotFoundException {
		Optional<UniversityStaffMember> usm = repository.findById(staffId);
		if (!usm.isPresent())
			throw new StaffMemberNotFoundException();
		repository.deleteById(staffId);
	}
	
	
	
}