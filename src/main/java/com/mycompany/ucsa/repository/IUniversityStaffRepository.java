package com.mycompany.ucsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.ucsa.entities.Course;
import com.mycompany.ucsa.entities.UniversityStaffMember;

@Repository

public interface IUniversityStaffRepository extends JpaRepository<UniversityStaffMember, Integer> {

	Course save(Course course);
	
}