package com.mycompany.ucsa.repository;


//import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.ucsa.entities.Faculty;
//import com.mycompany.ucsa.dto.FacultyOrderResponse;

@Repository
public interface IFacultyRepository extends JpaRepository<Faculty, Integer>{
	
//	@Query("SELECT new com.mycompany.ucsa.dto.FacultyOrderResponse(c.CourseName) FROM Faculty f JOIN f.course c WHERE f.FacultyId=:id")
//	public List<FacultyOrderResponse> getCourseByFaculty(@Param("id") int id);
	
}