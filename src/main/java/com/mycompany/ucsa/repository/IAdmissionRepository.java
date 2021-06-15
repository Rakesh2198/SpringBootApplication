package com.mycompany.ucsa.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.ucsa.dto.OrderResponse1;
import com.mycompany.ucsa.entities.Admission;

@Repository
public interface IAdmissionRepository extends JpaRepository<Admission, Integer> {
	
	
	@Query("select new com.mycompany.ucsa.dto.OrderResponse1(a.admissionId, a.courseId, a.applicantId, a.admissionDate) from Admission a where a.courseId=:id")
	public List<OrderResponse1> showAllAdmissionsByCourse(@Param("id") int id);

	@Query("select new com.mycompany.ucsa.dto.OrderResponse1(a.admissionId, a.courseId, a.applicantId, a.admissionDate) from Admission a where a.admissionDate=:date")
	public List<OrderResponse1> showAllAdmissionsByDate(@Param("date") java.util.Date date);
	
	@Query("SELECT new com.mycompany.ucsa.dto.OrderResponse1(adm.admissionId, adm.courseId, adm.applicantId, adm.admissionDate) FROM Admission adm WHERE adm.applicantId=:id")
	public List<OrderResponse1> showAllAdmissionsByApplicant(@Param("id") int id);

}