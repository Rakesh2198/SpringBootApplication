package com.mycompany.ucsa.service;

import java.util.List;


import javax.validation.Valid;

import org.springframework.stereotype.Service;

//import com.mycompany.ucsa.entities.Course;
import com.mycompany.ucsa.entities.UniversityStaffMember;
import com.mycompany.ucsa.exception.StaffMemberNotFoundException;

@Service
public interface IUniversityStaffService {

	List<UniversityStaffMember> fetchAll();
	
	

	UniversityStaffMember addUniversityStaffMember(@Valid UniversityStaffMember universitystaffmember);

	void updateStaff(@Valid UniversityStaffMember universitystaffmember);

	UniversityStaffMember fetchById(int staffId) throws StaffMemberNotFoundException;

	void deleteStaffMember(int staffId) throws StaffMemberNotFoundException;

	

	
}