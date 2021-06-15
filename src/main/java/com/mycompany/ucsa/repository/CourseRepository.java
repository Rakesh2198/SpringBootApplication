package com.mycompany.ucsa.repository;

import java.util.List;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.ucsa.dto.OrderResponse;
import com.mycompany.ucsa.entities.*;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
  
	

	
	@Query("SELECT new com.mycompany.ucsa.dto.OrderResponse(c.CourseName, f.Name) FROM Course c JOIN c.faculty f WHERE c.Couseid=:id")
	
	public List<OrderResponse> getFacultyNameByCourse(@Param("id") int id);

}

